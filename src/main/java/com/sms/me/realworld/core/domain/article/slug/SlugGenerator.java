package com.sms.me.realworld.core.domain.article.slug;

public class SlugGenerator {

    public static final String SEPARATOR = "-";

    /*
    a, the -> ""
     */
    public static String generate(String title) {
        return title.toLowerCase()
                .replaceAll("\\b(a|the)\\b", "")
                .replaceAll(" +", " ")
                .replaceAll("\\s+", SEPARATOR);
    }
}