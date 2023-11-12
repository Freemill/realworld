create table users
(
    id       bigint primary key auto_increment comment '유저 시퀀스',
    email    varchar(50)  not null comment '이메일',
    password varchar(255) not null comment '비밀번호',
    unique uk_email(email)
);