package com.sms.me.realworld.api.controller.dto;

import lombok.Getter;

@Getter
public class SingleArticleResponse {
    private final ArticleResponse article;

    public SingleArticleResponse(ArticleResponse article) {
        this.article = article;
    }
}
