package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import sun.misc.resources.Messages;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

class NotSavedSubEntityException extends Exception{
    public NotSavedSubEntityException(String message){
        super(message);
    }
}

public class MessagesRepositoryJdbcImpl implements MessagesRepository{

    private DataSource ds;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
		this.ds = ds;//получаем пул соединений для соединений JDBC
	}

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        Optional<Message> messageOptional = Optional.empty();

        Connection connection = ds.getConnection();//получаем соединение с базой данных

        Statement statement = connection.createStatement();//создаем объект для выполнения запросов
        //проверяем, есть ли сообщения по указанному id

        //выполняем запрос на поиск сообщения по id
        String sqlBodyRequest =
            "SELECT messages.*, chatrooms.name AS room_name,  users.login, users.password " +
            "FROM messages " +
            "LEFT JOIN chatrooms ON messages.chatroom_id = chatrooms.id " +
            "LEFT JOIN users ON chatrooms.owner_id = users.id " +
            "WHERE messages.id = " + id.toString();

        ResultSet res = statement.executeQuery(sqlBodyRequest);

        if (!res.next())
            return messageOptional;
        //создаем объект пользователя
        User user = new User(res.getLong("sender_id"), res.getString("login"), res.getString("password"), new ArrayList<Chatroom>(), new ArrayList<Chatroom>());

        //создаем объект чата
        Chatroom chat = new Chatroom(res.getLong("chatroom_id"), res.getString("room_name"), user, new ArrayList<Message>());

        //создаем объект сообщения
        Message message = new Message(res.getLong("id"), res.getString("content"), user, chat, res.getTimestamp("date").toLocalDateTime());

        //преобразуем объект сообщения в объект Optional для возврата в методе findById
        messageOptional = Optional.of(message);
        //закрываем соединение с базой данных?

        return messageOptional;
    }

    public Long save(Message message) throws SQLException, NotSavedSubEntityException {

        Long messageId = -1L;

        String sqlBodyRequest;

        Connection connection = ds.getConnection();//получаем соединение с базой данных

        Statement statement = connection.createStatement();//создаем объект для выполнения запросов
        if (message.getSender() == null || message.getChatroom() == null)
            throw new NotSavedSubEntityException("The message data was not saved. There is no sender or chat room.");

        sqlBodyRequest =
                "SELECT COUNT(1) AS cnt FROM " +
                    "(SELECT id FROM users WHERE id = " + message.getSender().getId().toString() +
                    " UNION ALL " +
                    "SELECT id FROM chatrooms WHERE id = " + message.getChatroom().getId().toString() +
                    ") AS cnts";

        ResultSet res = statement.executeQuery(sqlBodyRequest);
        res.next();
        if (res.getInt("cnt") != 2)
            throw new NotSavedSubEntityException("The message data was not saved. There is no sender or chat room.");

        Optional<Message> messageInDB = findById(message.getId());
        if (messageInDB.isPresent()) {
            sqlBodyRequest =
                    "UPDATE messages " +
                        "SET sender_id = " + message.getSender().getId().toString() +
                            ", chatroom_id = " + message.getChatroom().getId().toString() +
                            ", content = " + message.getContent() +
                            ", date = '" + message.getTimestamp() + "' " +
                    "WHERE id = " + message.getId().toString() + ";";
            statement.executeUpdate(sqlBodyRequest);
            messageId = message.getId();
        } else {

            sqlBodyRequest =
                    "INSERT INTO messages (sender_id, chatroom_id, content, date) " +
                            "VALUES (" + message.getSender().getId().toString() +
                            ", " + message.getChatroom().getId().toString() +
                            ", '" + message.getContent() + "'" +
                            ", '" + message.getTimestamp() + "'" +
                            ");";
            statement.execute(sqlBodyRequest, RETURN_GENERATED_KEYS);

            res = statement.getGeneratedKeys();
            if (res.next()) {
                messageId = res.getLong("id");
            }
        }
        return messageId;
    }
}
