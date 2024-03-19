package com.sms.me.realworld.core.domain.article.articleuser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FavoriteArticleService {

    private final FavoriteArticleRepository favoriteArticleRepository;

    @Transactional
    public boolean favoriteArticle(Long userId, Long articleId) {
        FavoriteArticleEntity favoriteArticleEntity = new FavoriteArticleEntity(articleId, userId);
        favoriteArticleRepository.save(favoriteArticleEntity);

        return true;
    }

    @Transactional
    public boolean unfavoriteArticle(Long userId, Long articleId) {
        FavoriteArticleEntity favoriteArticleEntity = new FavoriteArticleEntity(articleId, userId);
        favoriteArticleRepository.delete(favoriteArticleEntity);

        return false;
    }
}
