package com.YoutubeTools.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class YoutubeApiService {

    @Value("${youtube.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<String> getVideoTags(String videoId) {
        String url = String.format("https://www.googleapis.com/youtube/v3/videos?part=snippet&id=%s&key=%s", videoId,
                apiKey);
        List<String> tags = new ArrayList<>();

        try {
            String response = restTemplate.getForObject(new URI(url), String.class);
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode itemsNode = rootNode.path("items");

            if (itemsNode.isArray() && itemsNode.size() > 0) {
                JsonNode snippetNode = itemsNode.get(0).path("snippet");
                JsonNode tagsNode = snippetNode.path("tags");

                if (tagsNode.isArray()) {
                    for (JsonNode tagNode : tagsNode) {
                        tags.add(tagNode.asText());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tags;
    }

    public List<String> getTrendingTagsByKeyword(String keyword) {
        Set<String> allTags = new HashSet<>();
        try {
            String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.name());
            // Search for top 5 videos matching the keyword
            String searchUrl = String.format(
                    "https://www.googleapis.com/youtube/v3/search?part=id&type=video&q=%s&maxResults=5&key=%s",
                    encodedKeyword, apiKey);
            String searchResponse = restTemplate.getForObject(new URI(searchUrl), String.class);
            JsonNode searchRoot = objectMapper.readTree(searchResponse);
            JsonNode searchItems = searchRoot.path("items");

            List<String> videoIds = new ArrayList<>();
            if (searchItems.isArray()) {
                for (JsonNode item : searchItems) {
                    JsonNode idNode = item.path("id");
                    if (idNode.has("videoId")) {
                        videoIds.add(idNode.path("videoId").asText());
                    }
                }
            }

            // Fetch tags for these top videos
            if (!videoIds.isEmpty()) {
                String idsParam = String.join(",", videoIds);
                String videosUrl = String.format(
                        "https://www.googleapis.com/youtube/v3/videos?part=snippet&id=%s&key=%s", idsParam, apiKey);

                String videosResponse = restTemplate.getForObject(new URI(videosUrl), String.class);
                JsonNode videosRoot = objectMapper.readTree(videosResponse);
                JsonNode videosItems = videosRoot.path("items");

                if (videosItems.isArray()) {
                    for (JsonNode item : videosItems) {
                        JsonNode tagsNode = item.path("snippet").path("tags");
                        if (tagsNode.isArray()) {
                            for (JsonNode tagNode : tagsNode) {
                                allTags.add(tagNode.asText()); // Set ensures uniqueness
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>(allTags);
    }
}
