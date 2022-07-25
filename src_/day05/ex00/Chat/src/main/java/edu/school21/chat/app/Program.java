package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;

public class Program {
	public static void main(String[] args) throws SQLException {
		HikariDataSource dataSource = new HikariDataSource();
		/**HikariDataSource — это класс, предоставляющий пул соединений для соединений JDBC.
		Это оболочка вокруг вызова JDBC DriverManager.getConnection().
		Это синглтон, поэтому можно получить объект из любого места программы.
		*/

		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5433/postgres");//путь к базе данных
		dataSource.setUsername("");//логин пользователя
		dataSource.setPassword("");//пароль пользователя

		MessagesRepository messageRepo = new MessagesRepositoryJdbcImpl(dataSource);

		Optional<Message> message = messageRepo.findById(3L);
		System.out.println(message.toString());
		dataSource.close();
	}
}
