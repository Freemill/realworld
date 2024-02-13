package com.sms.me.realworld.api.docs;

import com.sms.me.realworld.api.controller.dto.TagListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "tag", description = "Tag API")
public interface TagApiSpec {

    @Operation(summary = "태그 조회")
    TagListResponse getTags();

}
