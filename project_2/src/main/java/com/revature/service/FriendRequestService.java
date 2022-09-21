package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.repository.FriendRequestRepository;
import com.revature.repository.entity.FriendRequest;

public class FriendRequestService {
	
	private FriendRequestRepository friendRequestRepository;

	@Autowired
	public FriendRequestService(FriendRequestRepository friendRequestRepository) {
		this.friendRequestRepository = friendRequestRepository;
	}
	
	public Optional<FriendRequest> findById(Long id)
	{
		return friendRequestRepository.findById(id);
	}

	public FriendRequest save(FriendRequest friendRequest)
	{
		return friendRequestRepository.save(friendRequest);
	}
	
	public void deleteById(Long id)
	{
		friendRequestRepository.deleteById(id);
	}
}
