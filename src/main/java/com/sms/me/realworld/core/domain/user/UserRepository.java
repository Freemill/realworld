package com.sms.me.realworld.core.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;


interface UserRepository extends JpaRepository<UserEntity, Long> {


}
