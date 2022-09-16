package com.revature.repository.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int message_id;
	
	private int character_id;
	
	private String message;
	
	private LocalDate timestamp;

	public ChatMessage() {
		super();
	}

	public ChatMessage(int message_id, int character_id, String message, LocalDate timestamp) {
		super();
		this.message_id = message_id;
		this.character_id = character_id;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public int getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(int character_id) {
		this.character_id = character_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(character_id, message, message_id, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatMessage other = (ChatMessage) obj;
		return character_id == other.character_id && Objects.equals(message, other.message)
				&& message_id == other.message_id && Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "ChatMessage [message_id=" + message_id + ", character_id=" + character_id + ", message=" + message
				+ ", timestamp=" + timestamp + "]";
	}
	
	
}
