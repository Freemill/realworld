create table users
(
    id       bigint primary key auto_increment comment '유저 시퀀스',
    email    varchar(50)  not null comment '이메일',
    password varchar(255) not null comment '비밀번호',
    username varchar(255) not null comment '유저명',
    bio      text         not null comment '자기소개',
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

create table articles
(
    id              bigint primary key auto_increment comment '아티클 시퀀스',
    author_id       bigint       not null comment '작성자 아이디',
    slug            varchar(100) not null comment '슬러그',
    title           varchar(50)  not null comment '제목',
    description     varchar(255) not null comment '설명',
    body            text         not null comment '내용',
    favorites_count int          not null default 0 comment '좋아요 수',

    unique uk_slug (slug)
);

create table slugs
(
    name  varchar(100) primary key comment '슬러그 명',
    count int not null default 1 comment '슬러그 카운트'
)