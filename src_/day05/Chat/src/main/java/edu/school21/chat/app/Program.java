package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws SQLException{

		System.out.println("---\tCheck ex01 (Start)\t---\n");
		System.out.print("-> ");
		Scanner scan = new Scanner(System.in);
		Long messageID = scan.nextLong();
		scan.close();

		final String pathDB = "jdbc:postgresql://localhost:5432/postgres";
		HikariDataSource dataSource = new HikariDataSource();
		/**HikariDataSource — это класс, предоставляющий пул соединений для соединений JDBC.
		Это оболочка вокруг вызова JDBC DriverManager.getConnection().
		Это синглтон, поэтому можно получить объект из любого места программы.
		*/

		dataSource.setJdbcUrl(pathDB);//путь к базе данных
		dataSource.setUsername("aarnell");//логин пользователя
		dataSource.setPassword("");//пароль пользователя

		MessagesRepository messageRepo = new MessagesRepositoryJdbcImpl(dataSource);

		Optional<Message> message = messageRepo.findById(messageID);

		System.out.println(message.toString());
		System.out.println("\n---\tCheck ex01 (End)\t---\n");

		System.out.println("\n---\tCheck ex02 (Start)\t---\n");
		User owner = new User(3L, "user_3", "easy_pas_3", null, null);
		User sender = new User(2L, "user_2", "easy_pas_2", null, null);
		Chatroom room = new Chatroom(5L, "room_5", owner, null);
		Message message1 = new Message(null, "HELLO WORLD!!!", sender, room, LocalDateTime.now());
		MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);

		try {
			messagesRepository.save(message1);
			System.out.println(message1.getId());
		} catch (Exception ex) {
			System.err.println("NotSavedSubEntityException " + ex.getMessage());
		}

		System.out.println("\n---\tCheck ex02 (End)\t---\n");
		dataSource.close();
	}
}
