package com.sms.me.realworld.core.domain.article;

import com.sms.me.realworld.core.domain.profile.Profile;
import com.sms.me.realworld.core.domain.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class Article {

    private long id;
    private String slug;
    private String title;
    private String description;
    private String body;
    private List<Tag> tagList;
    private boolean favorited;
    private Integer favoritesCount;
    private Profile author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static Article of(ArticleEntity entity) {
        return Article.builder()
                .id(entity.getId())
                .slug(entity.getSlug())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .body(entity.getBody())
                .favoritesCount(entity.getFavoritesCount())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .build();
    }

    public void enhance(List<Tag> tags, Profile author, boolean favorited) {
        enhance(tags);
        enhance(author, favorited);
    }

    private void enhance(List<Tag> tags) {
        this.tagList = tags;
    }

    private void enhance(Profile author, boolean favorited) {
        this.author = author;
        this.favorited = favorited;
    }
}
