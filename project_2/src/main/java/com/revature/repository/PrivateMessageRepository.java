package com.revature.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.repository.entity.PrivateMessage;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Long> {

	public Optional<List<PrivateMessage>> findTop20ByToUserId(long id);
}
