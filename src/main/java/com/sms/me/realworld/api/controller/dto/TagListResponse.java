package com.sms.me.realworld.api.controller.dto;

import com.sms.me.realworld.core.domain.tag.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TagListResponse {
    private List<String> tags;

    public static TagListResponse of(List<Tag> tags) {
        return new TagListResponse(tags.stream().map(Tag::getName).toList());
    }
}
