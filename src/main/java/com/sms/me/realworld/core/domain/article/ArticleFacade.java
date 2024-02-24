package com.sms.me.realworld.core.domain.article;

import com.sms.me.realworld.core.domain.article.command.ArticleCreateCommand;
import com.sms.me.realworld.core.domain.article.slug.SlugRepository;
import com.sms.me.realworld.core.domain.profile.Profile;
import com.sms.me.realworld.core.domain.profile.ProfileFacade;
import com.sms.me.realworld.core.domain.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleFacade {
    private final ArticleService articleService;
    private final SlugRepository slugRepository;
    private final ProfileFacade profileFacade;
    private final TagService tagService;

    public Article createArticle(ArticleCreateCommand command) {
        Article article = articleService.createArticle(command);
        Profile profile = profileFacade.getProfile(command.getAuthorId(), command.getAuthorId());

        article.enhance(profile, false);

        return article;
    }


}
