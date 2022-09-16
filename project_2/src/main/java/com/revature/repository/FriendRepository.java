package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.repository.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {

}
