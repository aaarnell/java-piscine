package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.List;

public class Chatroom {

	private Long id;

	private String name;

	private User owner;

	List<Message> messages;

	public Chatroom (Long id, String name, User owner, List<Message> messages) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

    public void setName(String name){
        this.name = name;
    }

	public User getOwner() {
		return owner;
	}

    public void setOwner(User owner) {
        this.owner = owner;
    }

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int hashCode() {
		final int prime = 4;
		return (prime * id.hashCode() + prime);
	}

	public boolean equals(Chatroom chatroom) {
		if (this.hashCode() != chatroom.hashCode())
			return false;
		return true;
	}

	public String toString() {
		String res = "[ROOM] >>" +
				" | id: " + id +
				" | name: " + name +
				" | owner: " + owner +
				" | messageList: " + messages +
				" | <<";
		return res;
	}
}
