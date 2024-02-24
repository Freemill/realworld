package com.sms.me.realworld.api.controller.dto;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sms.me.realworld.core.domain.article.Article;
import com.sms.me.realworld.core.domain.profile.Profile;
import com.sms.me.realworld.core.domain.tag.Tag;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("article")
@Builder
@Getter
public class ArticleCreateResponse {
    private String slug;
    private String title;
    private String description;
    private String body;
    private List<Tag> tagList;
    private boolean favorited;
    private Integer favoritesCount;
    private Profile author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ArticleCreateResponse of(Article article) {
        return ArticleCreateResponse.builder()
                .slug(article.getSlug())
                .title(article.getTitle())
                .description(article.getDescription())
                .body(article.getBody())
                .favorited(false)
                .favoritesCount(article.getFavoritesCount())
                .author(article.getAuthor())
                .build();
    }
}
