package com.sms.me.realworld.api.controller;

import com.sms.me.realworld.api.controller.dto.ArticleCreateRequest;
import com.sms.me.realworld.api.controller.dto.ArticleCreateResponse;
import com.sms.me.realworld.api.docs.ArticleApiSpec;
import com.sms.me.realworld.api.security.AuthUserDetails;
import com.sms.me.realworld.core.domain.article.Article;
import com.sms.me.realworld.core.domain.article.ArticleFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<String> getArticles(
            @RequestParam(defaultValue = "") String tag,
            @RequestParam(defaultValue = "") String author,
            @RequestParam(defaultValue = "") String favorited,
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(defaultValue = "0") int offset
    ) {
        return Collections.emptyList();
    }
}