package com.sms.me.realworld.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sms.me.realworld.core.domain.article.command.ArticleCreateCommand;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("article")
@Getter
public class ArticleCreateRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String body;

    private List<String> tagList;

    public ArticleCreateCommand toCommand(Long userId) {
        return ArticleCreateCommand.builder()
                .authorId(userId)
                .title(title)
                .description(description)
                .body(body)
                .tagList(tagList)
                .build();
    }

}
