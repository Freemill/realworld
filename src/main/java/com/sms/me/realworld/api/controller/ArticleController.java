package com.sms.me.realworld.api.controller;

import com.sms.me.realworld.api.controller.dto.*;
import com.sms.me.realworld.api.docs.ArticleApiSpec;
import com.sms.me.realworld.api.security.AuthUserDetails;
import com.sms.me.realworld.core.domain.article.Article;
import com.sms.me.realworld.core.domain.article.ArticleFacade;
import com.sms.me.realworld.core.domain.profile.Profile;
import com.sms.me.realworld.core.domain.tag.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController implements ArticleApiSpec {

    private final ArticleFacade articleFacade;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ArticleCreateResponse createArticle(
            @AuthenticationPrincipal AuthUserDetails userDetails,
            @RequestBody @Valid ArticleCreateRequest articleCreateRequest
    ) {
        Article article = articleFacade.createArticle(articleCreateRequest.toCommand(userDetails.userId));
        return ArticleCreateResponse.of(article);
    }

    @PostMapping("/{slug}/favorite")
    @PreAuthorize("hasRole('USER')")
    public SingleArticleResponse favoriteArticle(
            @AuthenticationPrincipal AuthUserDetails userDetails,
            @PathVariable String slug
    ) {
        Article article = articleFacade.favoriteArticle(userDetails.userId, slug);
        return new SingleArticleResponse(ArticleResponse.of(article));
    }

    @DeleteMapping("/{slug}/favorite")
    @PreAuthorize("hasRole('USER')")
    public SingleArticleResponse unfavoriteArticle(
            @AuthenticationPrincipal AuthUserDetails userDetails,
            @PathVariable String slug
    ) {
        Article article = articleFacade.unfavoriteArticle(userDetails.userId, slug);
        return new SingleArticleResponse(ArticleResponse.of(article));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('NO_AUTH', 'USER')")
    public MultipleArticleResponse getArticles(
            @AuthenticationPrincipal AuthUserDetails userDetails,
            @RequestParam(defaultValue = "") String tag,
            @RequestParam(defaultValue = "") String author,
            @RequestParam(defaultValue = "") String favorited,
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(defaultValue = "0") int offset
    ) {
//        Long userId = userDetails.userId;
//        Pageable pageable = PageRequest.of(offset, limit);
//
//        articleFacade.getArticle(pageable, tag, author, favorited);
        return new MultipleArticleResponse(List.of(ArticleResponse.builder()
                .title("title")
                .description("description")
                .body("body")
                .favorited(false)
                .favoritesCount(1)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .tagList(List.of("tag1", "tag2"))
                .author(Profile.builder().username("username").image("").bio("bio").following(false).build())
                .slug("title")
                .build()
        ), 1);
    }

    @GetMapping("/feed")
    @PreAuthorize("hasRole('USER')")
    public MultipleArticleResponse feedArticles() {
        return new MultipleArticleResponse(Collections.emptyList(), 0);
    }
}