package com.sms.me.realworld.core.domain.articletag;

import com.sms.me.realworld.core.domain.article.Article;
import com.sms.me.realworld.core.domain.article.ArticleTagEntity;
import com.sms.me.realworld.core.domain.article.ArticleTagRepository;
import com.sms.me.realworld.core.domain.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {

    private final ArticleTagRepository articleTagsRepository;

    @Transactional
    public void createArticleTag(Article article, List<Tag> tags) {
        List<ArticleTagEntity> entities = tags.stream()
                .map(tag -> new ArticleTagEntity(article.getId(), tag.getId())).toList();

        articleTagsRepository.saveAll(entities);
    }

}
