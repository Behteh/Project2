package com.revature.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.repository.entity.GameUser;


public interface GameUserRepository extends JpaRepository <GameUser, Long> {

	public Optional<GameUser> findGameUserByUsernameAndPassword(String username, String password);
	
	public Optional<GameUser> getGameUserById();
}
