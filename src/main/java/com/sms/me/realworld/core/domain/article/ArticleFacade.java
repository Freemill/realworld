package com.sms.me.realworld.core.domain.article;

import com.sms.me.realworld.core.domain.article.articletag.ArticleTagService;
import com.sms.me.realworld.core.domain.article.articleuser.FavoriteArticleService;
import com.sms.me.realworld.core.domain.article.command.ArticleCreateCommand;
import com.sms.me.realworld.core.domain.profile.Profile;
import com.sms.me.realworld.core.domain.profile.ProfileFacade;
import com.sms.me.realworld.core.domain.tag.Tag;
import com.sms.me.realworld.core.domain.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ArticleFacade {
    private final ArticleQueryService articleQueryService;
    private final ArticleService articleService;
    private final ProfileFacade profileFacade;
    private final TagService tagService;
    private final ArticleTagService articleTagService;
    private final FavoriteArticleService favoriteArticleService;

    public Article createArticle(ArticleCreateCommand command) {
        // article
        Article article = articleService.createArticle(command);

        // tags
        List<Tag> tags = tagService.createOrGetTags(Set.copyOf(command.getTagList()));

        // articleTags
        articleTagService.createArticleTag(article, tags);

        // profile
        Profile profile = profileFacade.getProfile(command.getAuthorId(), command.getAuthorId());

        article.enhance(tags, profile, false);

        return article;
    }

    public List<Article> getArticle(Pageable pageable, String tag, String author, boolean favorited) {
        //User user = userQueryService.getUserOrThrow(userId);
        articleService.getArticle(pageable, tag, author, favorited);

        return null;
    }

    @Transactional
    public Article favoriteArticle(Long userId, String slug) {
        // article
        ArticleEntity articleEntity = articleQueryService.getArticleEntityOrThrow(slug);

        // favorite article
        boolean favorited = favoriteArticleService.favoriteArticle(userId, articleEntity.getId());
        articleEntity.increaseFavoritesCount();

        return enhance(articleEntity, userId, favorited);
    }

    public Article unfavoriteArticle(Long userId, String slug) {
        // article
        ArticleEntity articleEntity = articleQueryService.getArticleEntityOrThrow(slug);

        // unfavorite article
        boolean favorited = favoriteArticleService.unfavoriteArticle(userId, articleEntity.getId());
        articleEntity.decreaseFavoritesCount();

        return enhance(articleEntity, userId, favorited);
    }

    public Article enhance(ArticleEntity entity, Long userId, boolean favorited) {
        Long articleId = entity.getId();
        Long authorId = entity.getAuthorId();

        // tags
        List<Tag> tags = articleTagService.getArticleTags(articleId);

        // profile
        Profile author = profileFacade.getProfile(userId, authorId);

        Article article = Article.of(entity);

        article.enhance(tags, author, favorited);

        return article;
    }
}
