create table users
(
    id       bigint primary key auto_increment comment '유저 시퀀스',
    email    varchar(50)  not null comment '이메일',
    password varchar(255) not null comment '비밀번호',
    username varchar(255) not null comment '유저명',
    bio      text         default null comment '자기소개',
    image    varchar(255) default null comment '이미지',
    unique uk_email (email)
);

create table follows
(
    id           bigint primary key key auto_increment comment '팔로우 시퀀스',
    following_id bigint not null comment '팔로우 유저 아이디',
    follower_id  bigint not null comment '팔로워 유저 아이디'
)