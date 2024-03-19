package com.sms.me.realworld.api.controller;

import com.sms.me.realworld.api.controller.dto.TagListResponse;
import com.sms.me.realworld.api.docs.TagApiSpec;
import com.sms.me.realworld.core.domain.tag.Tag;
import com.sms.me.realworld.core.domain.tag.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tags")
@Slf4j
public class TagController implements TagApiSpec {

    private final TagService tagService;

    @GetMapping
    @PreAuthorize("hasAnyRole('NO_AUTH', 'USER')")
    public TagListResponse getTags() {
        List<Tag> tags = tagService.getAllTags();

        return TagListResponse.of(tags);
    }

}
