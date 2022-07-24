package edu.school21.chat.models;

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

    public User (Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.ownerChatRooms = new ArrayList<Chatroom>();
        this.senderChatRooms = new ArrayList<Chatroom>();
    }

    public int hashCode() {
        final int prime = 3;
        return (prime * id.hashCode() + prime);
    }

}
