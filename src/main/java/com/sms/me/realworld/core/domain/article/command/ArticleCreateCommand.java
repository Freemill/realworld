package com.sms.me.realworld.core.domain.article.command;

import com.sms.me.realworld.core.domain.article.ArticleEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ArticleCreateCommand {

    private Long authorId;
    private String title;
    private String description;
    private String body;
    private List<String> tagList;

    public ArticleEntity toEntity(String slug) {
        return ArticleEntity.builder()
                .authorId(authorId)
                .slug(slug)
                .title(title)
                .description(description)
                .body(body)
                .favoritesCount(0)
                .build();
    }

}
