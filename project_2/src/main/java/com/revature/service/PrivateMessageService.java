package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.PrivateMessageRepository;
import com.revature.repository.entity.PrivateMessage;

@Service
public class PrivateMessageService {

	PrivateMessageRepository privateMessageRepository;

	@Autowired
	public PrivateMessageService(PrivateMessageRepository privateMessageRepository) {
		this.privateMessageRepository = privateMessageRepository;
	}


	public Optional<PrivateMessage> findById(Long id)
	{
		return privateMessageRepository.findById(id);
	}
	
	public PrivateMessage save(PrivateMessage privateMessage)
	{
		return privateMessageRepository.save(privateMessage);
	}
	
	public void deleteById(Long id)
	{
		privateMessageRepository.deleteById(id);
	}
	
}
