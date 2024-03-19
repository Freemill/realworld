package com.sms.me.realworld.core.domain.article.articletag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleTagRepository extends JpaRepository<ArticleTagEntity, Long> {
    List<ArticleTagEntity> findByArticleId(Long articleId);
}
