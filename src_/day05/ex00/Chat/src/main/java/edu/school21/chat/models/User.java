package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Driver;

public class User {

    private Long id;

    private String login;

    private String password;

    List<Chatroom> ownerChatRooms;

    List<Chatroom> senderChatRooms;

    public User (Long id, String login, String password, List<Chatroom> ownerChatRooms, List<Chatroom> senderChatRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.ownerChatRooms = ownerChatRooms;
        this.senderChatRooms = senderChatRooms;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin() {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getOwnerChatRooms() {
        return ownerChatRooms;
    }

    public void setOwnerChatRooms(List<Chatroom> ownerChatRooms) {
        this.ownerChatRooms = ownerChatRooms;
    }

    public List<Chatroom> getSenderChatRooms() {
        return ownerChatRooms;
    }

    public void setSenderChatRooms(List<Chatroom> senderChatRooms) {
        this.senderChatRooms = senderChatRooms;
    }

    public int hashCode() {
        final int prime = 3;
        return (prime * id.hashCode() + prime);
    }

    public boolean equals(User user) {
        if (this.hashCode() != user.hashCode())
            return false;
        return true;
    }

    public String toString() {
        String res = "[USER] >>" +
                " | id: " + id +
                " | login: " + login +
                " | ownerChatRooms: " + ownerChatRooms +
                " | senderChatRooms: " + senderChatRooms +
                " | <<";
        return res;
    }

}
