package com.sms.me.realworld.core.domain.tag;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll().stream()
                .map(entity -> new Tag(entity.getId(), entity.getName()))
                .toList();
    }

    public List<Tag> createOrGetTags(Set<String> tagList) {
        List<Tag> savedTags = tagRepository.findAllByNameIn(tagList).stream()
                .map(Tag::of)
                .toList();

        List<TagEntity> savingTags = tagList.stream()
                .filter(tagName -> savedTags.stream().noneMatch(tag -> tagName.equals(tag.getName())))
                .map(TagEntity::new)
                .toList();

        List<Tag> tags = tagRepository.saveAll(savingTags).stream()
                .map(Tag::of)
                .toList();

        return ListUtils.union(savedTags, tags);
    }
}
