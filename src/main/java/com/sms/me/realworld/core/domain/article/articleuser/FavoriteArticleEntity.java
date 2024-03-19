package com.sms.me.realworld.core.domain.article.articleuser;

import com.sms.me.realworld.core.domain.common.AuditableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "favorite_articles")
public class FavoriteArticleEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private Long articleId;

    @Column(nullable = false, updatable = false)
    private Long userId;

    public FavoriteArticleEntity(Long articleId, Long userId) {
        this.articleId = articleId;
        this.userId = userId;
    }
}
