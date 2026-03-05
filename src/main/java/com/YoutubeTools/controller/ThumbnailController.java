package com.YoutubeTools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.YoutubeTools.service.ThumbnailService;

@Controller
public class ThumbnailController {

    @Autowired
    ThumbnailService thumbnailService;

    @GetMapping("/thumbnails")
    public String thumbnails() {
        return "thumbnails";
    }

    @PostMapping("/thumbnails")
    public String showThumbnails(@RequestParam("search-input") String url, Model model) {
        String videoId = thumbnailService.extractVideoId(url);
        if (videoId != null) {
            model.addAttribute("videoId", videoId);
        } else {
            model.addAttribute("error", "Invalid Youtube URL");
            return "thumbnails";
        }
        return "thumbnails";
    }

}
