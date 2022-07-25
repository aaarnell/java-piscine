package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{

    private DataSource ds;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
		this.ds = ds;//получаем пул соединений для соединений JDBC
	}

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        Connection connection = ds.getConnection();//получаем соединение с базой данных

        Statement statement = connection.createStatement();//создаем объект для выполнения запросов
        //проверяем, есть ли сообщения по указанному id

        //выполняем запрос на поиск сообщения по id
        ResultSet res = statement.executeQuery("SELECT * FROM messages WHERE id = " + id);
        //если есть, то создаем объект сообщения

        //возвращаем объект сообщения

        //если нет, то возвращаем пустой объект?

        User user = new User(1, "new_user", "pass");//создаем объект пользователя
        Chatroom chat = new Chatroom(1, "new_chat", user);//создаем объект чата
        Message msg = new Message(res.getInt("id"), res.getString("content"), user, chat, LocalDateTime.of(2022,  1, 10, 22, 0, 0));//создаем объект сообщения
        Optional<Message> message = Optional.of(msg);//преобразуем объект сообщения в объект Optional для возврата в методе findById
        //закрываем соединение с базой данных?

        return message;
    }
}
