package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.GameUserRepository;
import com.revature.repository.entity.GameUser;

@Service
public class GameUserService {
	
	private GameUserRepository gameUserRepository;

	@Autowired
	public GameUserService(GameUserRepository gameUserRepository) {
		this.gameUserRepository = gameUserRepository;
	}
	
	public Optional<GameUser> findById(Long id)
	{
		return gameUserRepository.findById(id);
	}
	
	public Optional<GameUser> findByUsernameAndPassword(String username, String password)
	{
		return gameUserRepository.findGameUserByUsernameAndPassword(username, password);
	}
	
	public GameUser save(GameUser gameUser)
	{
		return gameUserRepository.save(gameUser);
	}
	
	public void deleteById(Long id)
	{
		gameUserRepository.deleteById(id);
	}

}