package com.revature.repository.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "friends")
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int friend_id;

	private int user1;

	private int user2;

	public Friend() {
		super();
	}

	public Friend(int friend_id, int user1, int user2) {
		super();
		this.friend_id = friend_id;
		this.user1 = user1;
		this.user2 = user2;
	}

	public int getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}

	public int getUser1() {
		return user1;
	}

	public void setUser1(int user1) {
		this.user1 = user1;
	}

	public int getUser2() {
		return user2;
	}

	public void setUser2(int user2) {
		this.user2 = user2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(friend_id, user1, user2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Friend other = (Friend) obj;
		return friend_id == other.friend_id && user1 == other.user1 && user2 == other.user2;
	}

	@Override
	public String toString() {
		return "Friend [friend_id=" + friend_id + ", user1=" + user1 + ", user2=" + user2 + "]";
	}


}
