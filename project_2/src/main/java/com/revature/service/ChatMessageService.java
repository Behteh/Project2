package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.ChatMessageRepository;
import com.revature.repository.entity.ChatMessage;

@Service
public class ChatMessageService {

	ChatMessageRepository chatMessageRepository;

	@Autowired
	public ChatMessageService(ChatMessageRepository chatMessageRepository) {
		this.chatMessageRepository = chatMessageRepository;
	}
	
	public Optional<ChatMessage> findById(Long id)
	{
		return chatMessageRepository.findById(id);
	}
	
	public ChatMessage save(ChatMessage chatMessage)
	{
		return chatMessageRepository.save(chatMessage);
	}
	
	public void deleteById(Long id)
	{
		chatMessageRepository.deleteById(id);
	}
	
	public Optional<?> getRecentMessages()
	{
		Optional<List<ChatMessage>> messages = chatMessageRepository.getRecentMessages();
		return messages;
	}

}