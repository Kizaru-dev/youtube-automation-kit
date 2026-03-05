package com.YoutubeTools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.YoutubeTools.service.ThumbnailService;
import com.YoutubeTools.service.YoutubeApiService;

import java.util.List;

@Controller
public class VideoDetailsController {

    @Autowired
    private YoutubeApiService youtubeApiService;

    @Autowired
    private ThumbnailService thumbnailService;

    @GetMapping("/video-details")
    public String videoDetails(@RequestParam(name = "url", required = false) String url, Model model) {
        if (url != null && !url.trim().isEmpty()) {

            String videoId = thumbnailService.extractVideoId(url);

            if (videoId != null) {
                // Determine Thumbnail URL
                String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/maxresdefault.jpg";
                model.addAttribute("thumbnailUrl", thumbnailUrl);

                // Fetch Actual Tags
                List<String> extractedTags = youtubeApiService.getVideoTags(videoId);
                model.addAttribute("tags", extractedTags);
            } else {
                model.addAttribute("error", "Invalid YouTube URL");
            }

            model.addAttribute("query", url);
        }

        return "video-details";
    }
}
