package com.sms.me.realworld.api.controller.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MultipleArticleResponse {
    private final List<ArticleResponse> articles;
    private final int articlesCount;

    public MultipleArticleResponse(List<ArticleResponse> articles, int articlesCount) {
        this.articles = articles;
        this.articlesCount = articlesCount;
    }
}
