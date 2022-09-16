package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.repository.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long>{

}
