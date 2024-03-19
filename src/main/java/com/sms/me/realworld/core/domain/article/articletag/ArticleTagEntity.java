package com.sms.me.realworld.core.domain.article.articletag;

import com.sms.me.realworld.core.domain.common.AuditableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "article_tags")
public class ArticleTagEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private Long articleId;

    @Column(nullable = false, updatable = false)
    private Long tagId;

    public ArticleTagEntity(Long articleId, Long tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }
}
