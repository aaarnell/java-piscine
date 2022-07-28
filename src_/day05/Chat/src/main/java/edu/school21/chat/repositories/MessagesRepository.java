package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;

import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
    public Optional<Message> findById(Long id) throws SQLException;//поиск сообщения по id
    public void save(Message message) throws SQLException, NotSavedSubEntityException;
}
