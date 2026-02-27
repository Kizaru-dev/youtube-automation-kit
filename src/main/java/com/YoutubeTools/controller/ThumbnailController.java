package com.YoutubeTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThumbnailController {

    @GetMapping("/thumbnails")
    public String thumbnails() {
        return "thumbnails";
    }

}
