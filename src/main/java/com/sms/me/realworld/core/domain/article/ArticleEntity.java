package com.sms.me.realworld.core.domain.article;


import com.sms.me.realworld.core.domain.common.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "articles")
public class ArticleEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long authorId;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Integer favoritesCount;

    public void increaseFavoritesCount() {
        this.favoritesCount++;
    }

    public void decreaseFavoritesCount() {
        this.favoritesCount--;
    }
}
