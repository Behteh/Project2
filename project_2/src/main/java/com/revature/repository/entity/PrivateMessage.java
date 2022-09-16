package com.revature.repository.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "private_messages")
public class PrivateMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int message_id;
	
	private int from_user_id;
	
	private int to_user_id;
	
	private String topic;
	
	private String message;
	
	private LocalDate timestamp;

	public PrivateMessage() {
		super();
	}

	public PrivateMessage(int message_id, int from_user_id, int to_user_id, String topic, String message,
			LocalDate timestamp) {
		super();
		this.message_id = message_id;
		this.from_user_id = from_user_id;
		this.to_user_id = to_user_id;
		this.topic = topic;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public int getFrom_user_id() {
		return from_user_id;
	}

	public void setFrom_user_id(int from_user_id) {
		this.from_user_id = from_user_id;
	}

	public int getTo_user_id() {
		return to_user_id;
	}

	public void setTo_user_id(int to_user_id) {
		this.to_user_id = to_user_id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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
		return Objects.hash(from_user_id, message, message_id, timestamp, to_user_id, topic);
	}

	@Override
	public String toString() {
		return "PrivateMessage [message_id=" + message_id + ", from_user_id=" + from_user_id + ", to_user_id="
				+ to_user_id + ", topic=" + topic + ", message=" + message + ", timestamp=" + timestamp + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrivateMessage other = (PrivateMessage) obj;
		return from_user_id == other.from_user_id && Objects.equals(message, other.message)
				&& message_id == other.message_id && Objects.equals(timestamp, other.timestamp)
				&& to_user_id == other.to_user_id && Objects.equals(topic, other.topic);
	}
	
	

}
