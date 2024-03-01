package com.sms.me.realworld.core.domain.tag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
    List<TagEntity> findAllByNameIn(Set<String> tagNames);

}
