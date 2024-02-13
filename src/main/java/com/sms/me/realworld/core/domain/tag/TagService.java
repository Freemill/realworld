package com.sms.me.realworld.core.domain.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getTags() {
        return tagRepository.findAll().stream()
                .map(entity -> new Tag(entity.getName()))
                .toList();
    }
}
