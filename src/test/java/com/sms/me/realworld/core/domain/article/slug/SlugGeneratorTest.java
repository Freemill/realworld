package com.sms.me.realworld.core.domain.article.slug;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlugGeneratorTest {

    @Test
    void generate() {
        // given
        String title = "What Does the Fox Say";

        // when
        String slug = SlugGenerator.generate(title);

        // then
        assertEquals("what-does-fox-say", slug);
    }
}