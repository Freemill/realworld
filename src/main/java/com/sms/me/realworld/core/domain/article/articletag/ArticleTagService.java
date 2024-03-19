package com.sms.me.realworld.core.domain.article.articletag;

import com.sms.me.realworld.core.domain.article.Article;
import com.sms.me.realworld.core.domain.tag.Tag;
import com.sms.me.realworld.core.domain.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {

    private final ArticleTagRepository articleTagsRepository;
    private final TagRepository tagRepository;

    @Transactional
    public void createArticleTag(Article article, List<Tag> tags) {
        List<ArticleTagEntity> entities = tags.stream()
                .map(tag -> new ArticleTagEntity(article.getId(), tag.getId())).toList();

        articleTagsRepository.saveAll(entities);
    }

    public List<Tag> getArticleTags(Long articleId) {
        List<Long> tagIds = articleTagsRepository.findByArticleId(articleId).stream()
                .map(ArticleTagEntity::getTagId).toList();
        return tagRepository.findAllById(tagIds).stream().map(Tag::of).toList();
    }
}
