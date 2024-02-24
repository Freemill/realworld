package com.sms.me.realworld.core.domain.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleQueryService {

    private final ArticleRepository articleRepository;

    public Article getArticle(String slug) {
        //ArticleEntity articleEntity = articleRepository.findBySlug(slug).orElseThrow();
        return null;
    }

}
