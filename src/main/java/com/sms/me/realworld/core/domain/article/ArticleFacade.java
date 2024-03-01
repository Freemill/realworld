package com.sms.me.realworld.core.domain.article;

import com.sms.me.realworld.core.domain.article.command.ArticleCreateCommand;
import com.sms.me.realworld.core.domain.articletag.ArticleTagService;
import com.sms.me.realworld.core.domain.profile.Profile;
import com.sms.me.realworld.core.domain.profile.ProfileFacade;
import com.sms.me.realworld.core.domain.tag.Tag;
import com.sms.me.realworld.core.domain.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ArticleFacade {
    private final ArticleService articleService;
    private final ProfileFacade profileFacade;
    private final TagService tagService;
    private final ArticleTagService articleTagService;

    public Article createArticle(ArticleCreateCommand command) {
        // article
        Article article = articleService.createArticle(command);

        // tag
        List<Tag> tags = tagService.createOrGetTags(Set.copyOf(command.getTagList()));

        // articleTag
        articleTagService.createArticleTag(article, tags);

        // profile
        Profile profile = profileFacade.getProfile(command.getAuthorId(), command.getAuthorId());

        article.enhance(tags, profile, false);

        return article;
    }


}
