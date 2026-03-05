package com.YoutubeTools.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class ThumbnailService {

    public String extractVideoId(String url) {
        if (url.matches("^[a-zA-Z0-9_-]{11}$")) {
            return url;
        }
        String[] patterns = {
                "(?:youtube\\.com/watch\\?v=|youtu\\.be/)([a-zA-Z0-9_-]{11})",
                "(?:youtube\\.com/embed/|youtube\\.com/v/)([a-zA-Z0-9_-]{11})",
                "(?:youtube\\.com/shorts/)([a-zA-Z0-9_-]{11})",
                "(?:www\\.)?youtube\\.com/shorts/([a-zA-Z0-9_-]{11})"
        };
        for (String pattern : patterns) {
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(url);
            if (m.find()) {
                return m.group(1);
            }
        }
        return null;

    }

}
