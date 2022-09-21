package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.repository.FriendRepository;
import com.revature.repository.entity.Friend;

public class FriendService {
	
	private FriendRepository friendRepository;

	@Autowired
	public FriendService(FriendRepository friendRepository) {
		this.friendRepository = friendRepository;
	}
	
	public Optional<Friend> findById(Long id)
	{
		return friendRepository.findById(id);
	}
	
	public Friend save(Friend friend)
	{
		return friendRepository.save(friend);
	}
	
	public void deleteById(Long id)
	{
		friendRepository.deleteById(id);
	}
}
