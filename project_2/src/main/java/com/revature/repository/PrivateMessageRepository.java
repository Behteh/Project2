package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.repository.entity.PrivateMessage;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Long> {

}
