package com.YoutubeTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({ "/", "home" })
    public String home() {
        return "home";
    }

    @GetMapping({ "/seo-tags" })
    public String seoTags() {
        return "seo"; // fallback/placeholder if doesn't exist yet
    }

    @GetMapping({ "/ai-thumbnail" })
    public String aiThumbnail() {
        return "ai-thumbnail";
    }
}
