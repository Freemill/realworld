package com.sms.me.realworld.core.domain.article;

import com.sms.me.realworld.core.exception.ErrorType;
import com.sms.me.realworld.core.exception.RealException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleQueryService {

    private final ArticleRepository articleRepository;

    public Article getArticleOrThrow(String slug) {
        ArticleEntity entity = getArticleEntityOrThrow(slug);
        return Article.of(entity);
    }

    public ArticleEntity getArticleEntityOrThrow(String slug) {
        return articleRepository.findBySlug(slug)
                .orElseThrow(() -> new RealException(ErrorType.NOT_FOUND));
    }
}
