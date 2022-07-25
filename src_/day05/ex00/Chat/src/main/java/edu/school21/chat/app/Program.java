package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;

public class Program {
	public static void main(String[] args) throws SQLException {
		HikariDataSource dataSource = new HikariDataSource();
		/**HikariDataSource — это класс, предоставляющий пул соединений для соединений JDBC.
		Это оболочка вокруг вызова JDBC DriverManager.getConnection().
		Это синглтон, поэтому можно получить объект из любого места программы.
		*/

		dataSource.setJdbcUrl("");//путь к базе данных
		dataSource.setUsername("");//логин пользователя
		dataSource.setPassword("");//пароль пользователя

	}
}
