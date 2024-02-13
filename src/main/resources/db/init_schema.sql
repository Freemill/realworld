create table users
(
    id       bigint primary key auto_increment comment '유저 시퀀스',
    email    varchar(50)  not null comment '이메일',
    password varchar(255) not null comment '비밀번호',
    username varchar(255) not null comment '유저명',
    bio      text         not null default '' comment '자기소개',
    image    varchar(255) not null default '' comment '이미지',
    unique uk_email (email),
    unique uk_username (username)
);

create table follows
(
    id           bigint primary key key auto_increment comment '팔로우 시퀀스',
    following_id bigint not null comment '팔로우 유저 아이디',
    follower_id  bigint not null comment '팔로워 유저 아이디'
);

create table tags
(
    id   bigint primary key key auto_increment comment '태그 시퀀스',
    name varchar(20) not null comment '태그명',
    unique uk_name (name)
);