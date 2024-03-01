package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.domain.common.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "users") //user는 예약어
public class UserEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(columnDefinition = "text", nullable = true)
    private String bio;

    @Column(nullable = true)
    private String image;

    public UserEntity update(String email, String username, String password, String bio, String image) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.image = image;
        return this;
    }
}
