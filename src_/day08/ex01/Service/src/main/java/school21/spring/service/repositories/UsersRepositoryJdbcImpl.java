package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class NotUpdateDataException extends Exception{
    public NotUpdateDataException(String message){
        super(message);
    }
}

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private final DataSource ds;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.ds = dataSource;
    }

    @Override
    public Optional<User> findById(Long id) throws SQLException {
        Connection connection = ds.getConnection();

        String sql = "SELECT * FROM data WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet res = preparedStatement.executeQuery();

        if (!res.next())
            return Optional.empty();
        return Optional.of(new User(res.getLong("id"), res.getString("email")));
    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        Connection connection = ds.getConnection();

        String sql = "SELECT * FROM data WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);

        ResultSet res = preparedStatement.executeQuery();

        if (!res.next())
            return Optional.empty();
        return Optional.of(new User(res.getLong("id"), res.getString("email")));
    }

    @Override
    public List<User> findAll() throws SQLException {
        Connection connection = ds.getConnection();

        String sql = "SELECT * FROM data";

        ResultSet res = connection.createStatement().executeQuery(sql);

        List<User> users = new ArrayList<>();
        while (res.next())
        {
            users.add(new User(res.getLong("id"), res.getString("email")));
        }
        return users;
    }

    @Override
    public void save(User entity) throws SQLException, NotUpdateDataException {

        if (findByEmail(entity.getEmail()).isPresent()) {
            throw new NotUpdateDataException("Unable to save user data. The user with this email is already in the database.");
        }

        Connection connection = ds.getConnection();

        String sql = "INSERT INTO data VALUES(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, entity.getEmail());

        preparedStatement.execute();

        ResultSet res = preparedStatement.getGeneratedKeys();
        res.next();
        entity.setId(res.getLong("id"));
    }

    @Override
    public void update(User entity) throws SQLException, NotUpdateDataException {

        if (!findById(entity.getId()).isPresent()) {
            throw new NotUpdateDataException("Unable to update user data. There is no user with the given ID in the database.");
        }

        Connection connection = ds.getConnection();
        String sql = "UPDATE data SET email = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, entity.getEmail());
        preparedStatement.setLong(2, entity.getId());
        preparedStatement.execute();
    }

    @Override
    public void delete(Long id) throws SQLException, NotUpdateDataException {

        if (!findById(id).isPresent()) {
            throw new NotUpdateDataException("Unable to delete user data. There is no user with the given ID in the database.");
        }

        Connection connection = ds.getConnection();
        String sql = "DELETE FROM data WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
