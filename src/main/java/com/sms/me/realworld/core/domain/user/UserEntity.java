package com.sms.me.realworld.core.domain.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users") //user는 예약어
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
//varchar(255) -> text로 바꾸기 검색 UserEntity 만들기

}
