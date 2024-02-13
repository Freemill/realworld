package com.sms.me.realworld.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @GetMapping
    public List<String> getArticles(
            @RequestParam(defaultValue = "") String tag,
            @RequestParam(defaultValue = "") String author,
            @RequestParam(defaultValue = "") String favorited,
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(defaultValue = "0") int offset
    ) {
        return Collections.emptyList();
    }
}