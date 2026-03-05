package com.YoutubeTools.controller;

import com.YoutubeTools.service.ThumbnailService;
import com.YoutubeTools.service.YoutubeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/youtube")
public class YoutubeApiController {

    @Autowired
    private YoutubeApiService youtubeApiService;

    @Autowired
    private ThumbnailService thumbnailService;

    @GetMapping("/seo-tags")
    public Map<String, Object> getSeoTags(@RequestParam("query") String query) {
        Map<String, Object> response = new HashMap<>();

        // Check if query is a URL
        String videoId = thumbnailService.extractVideoId(query);
        List<String> tags;

        if (videoId != null) {
            // It's a URL, fetch tags for that specific video
            tags = youtubeApiService.getVideoTags(videoId);
        } else {
            // It's a keyword, fetch trending tags for that keyword
            tags = youtubeApiService.getTrendingTagsByKeyword(query);
        }

        response.put("success", true);
        response.put("tags", tags);
        return response;
    }

    @GetMapping("/thumbnail")
    public Map<String, Object> getThumbnail(@RequestParam("url") String url) {
        Map<String, Object> response = new HashMap<>();
        String videoId = thumbnailService.extractVideoId(url);

        if (videoId != null) {
            String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/maxresdefault.jpg";
            response.put("success", true);
            response.put("thumbnailUrl", thumbnailUrl);
        } else {
            response.put("success", false);
            response.put("message", "Invalid YouTube URL");
        }

        return response;
    }
}
