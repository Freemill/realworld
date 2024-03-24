package com.sms.me.realworld.api.docs;

import com.sms.me.realworld.api.controller.dto.ArticleCreateRequest;
import com.sms.me.realworld.api.controller.dto.ArticleCreateResponse;
import com.sms.me.realworld.api.controller.dto.ArticleResponse;
import com.sms.me.realworld.api.controller.dto.MultipleArticleResponse;
import com.sms.me.realworld.api.security.AuthUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "article", description = "Article API")
public interface ArticleApiSpec {

    @Operation(summary = "게시물 생성")
    ArticleCreateResponse createArticle(
            AuthUserDetails userDetails,
            ArticleCreateRequest articleCreateRequest
    );

    @Operation(summary = "게시물 리스트 조회")
    MultipleArticleResponse getArticles(
            AuthUserDetails userDetails,
            String tag,
            String author,
            String favorited,
            int limit,
            int offset
    );

}