package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

	private Long id;

	private String content;

    private LocalDateTime timestamp;

	private User sender;

	private Chatroom chatroom;

	public Message(Long id, String content, User sender, Chatroom chatroom, LocalDateTime timestamp) {
		this.id = id;
		this.content = content;
		this.sender = sender;
		this.chatroom = chatroom;
        this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Chatroom getChatroom() {
		return chatroom;
	}

	public void setChatroom(Chatroom chatroom) {
		this.chatroom = chatroom;
	}

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

	public int hashCode() {
		final int prime = 2;
		return (prime * id.hashCode() + prime);
	}

	public boolean equals(Message message) {
		if (this.hashCode() != message.hashCode())
			return false;
		return true;
	}

	public String toString() {
		String res = "[MESSAGE] >>" +
				" | id: " + id +
				" | content: " + content +
				" | sender: " + sender +
				" | chatroom: " + chatroom +
				" | timestamp " + timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) +
				" | <<";
		return res;
	}
}
