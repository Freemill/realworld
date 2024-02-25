package com.sms.me.realworld.core.domain.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tag {
    private Long id;
    private String name;

    public static Tag of(TagEntity entity) {
        return new Tag(entity.getId(), entity.getName());
    }
}
