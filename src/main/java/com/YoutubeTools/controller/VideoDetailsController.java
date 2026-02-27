package com.YoutubeTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VideoDetailsController {

    @GetMapping("/video-details")
    public String videoDetails(@RequestParam(name = "url", required = false) String url, Model model) {
        if (url != null && !url.trim().isEmpty()) {
            // Placeholder: Extract Thumbnail URL
            String thumbnailUrl = "https://images.unsplash.com/photo-1611162617213-7d7a39e9b1d7?ixlib=rb-4.0.3&auto=format&fit=crop&w=1000&q=80";
            model.addAttribute("thumbnailUrl", thumbnailUrl);

            // Placeholder: Extract Tags
            List<String> extractedTags = new ArrayList<>();
            extractedTags.add("backend integration");
            extractedTags.add("spring boot");
            extractedTags.add("thymeleaf template");
            extractedTags.add("ui design");
            extractedTags.add("java tutorial");
            extractedTags.add("web development");
            extractedTags.add("frontend to backend");

            model.addAttribute("tags", extractedTags);
            model.addAttribute("query", url);
        }

        return "video-details";
    }
}
