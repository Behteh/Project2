package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.repository.entity.GameUser;


public interface GameUserRepository extends JpaRepository <GameUser, Long> {

}
