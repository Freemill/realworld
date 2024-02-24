package com.sms.me.realworld.core.domain.article.slug;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SlugRepository extends JpaRepository<SlugEntity, String> {
    SlugEntity findByName(String name);

}
