package com.sms.me.realworld.core.domain.article.slug;

import com.sms.me.realworld.core.domain.common.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "slugs")
public class SlugEntity extends AuditableEntity {

    @Id
    private String name;

    private Integer count;

    public void increaseCount() {
        this.count += 1;
    }
}
