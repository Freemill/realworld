package com.sms.me.realworld.core.domain.article;

import com.sms.me.realworld.core.domain.article.command.ArticleCreateCommand;
import com.sms.me.realworld.core.domain.article.slug.SlugEntity;
import com.sms.me.realworld.core.domain.article.slug.SlugGenerator;
import com.sms.me.realworld.core.domain.article.slug.SlugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final SlugRepository slugRepository;

    @Transactional
    public Article createArticle(ArticleCreateCommand command) {
        String slug = generateSlug(command.getTitle());
        ArticleEntity entity = articleRepository.save(command.toEntity(slug));
        return Article.of(entity);
    }

    private String generateSlug(String title) {
        String slug = SlugGenerator.generate(title);

        SlugEntity slugEntity = slugRepository.findByName(slug);

        if (slugEntity == null) { // 최초
            SlugEntity entity = new SlugEntity(slug, 1);
            slugRepository.save(entity);
            return slug;
        }

        slugEntity.increaseCount();
        slug += SlugGenerator.SEPARATOR + slugEntity.getCount();

        return slug;
    }
}
