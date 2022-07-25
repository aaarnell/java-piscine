package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Driver;

public class User {

    private Integer id;

    private String login;

    private String password;

    List<Chatroom> ownerChatRooms;

    List<Chatroom> senderChatRooms;

    public User (Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.ownerChatRooms = new ArrayList<Chatroom>();
        this.senderChatRooms = new ArrayList<Chatroom>();
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin() {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
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
