package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{
    private final JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findById(Long id) throws SQLException {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT * FROM data WHERE id = ?",
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("email")), id));
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT * FROM data WHERE email = ?",
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("email")), email));
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM data",
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("email")));
    }

    @Override
    public void save(User entity) throws NotUpdateDataException {

        if (findByEmail(entity.getEmail()).isPresent()) {
            throw new NotUpdateDataException("Unable to save user data. The user with this email is already in the database.");
        }

        jdbcTemplate.update("INSERT INTO data VALUES(?)", entity.getEmail());
    }

    @Override
    public void update(User entity) throws SQLException, NotUpdateDataException {

        if (!findById(entity.getId()).isPresent()) {
            throw new NotUpdateDataException("Unable to update user data. There is no user with the given ID in the database.");
        }

        jdbcTemplate.update("UPDATE data SET email = ? WHERE id = ?", entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) throws SQLException, NotUpdateDataException {

        if (!findById(id).isPresent()) {
            throw new NotUpdateDataException("Unable to delete user data. There is no user with the given ID in the database.");
        }

        jdbcTemplate.update("DELETE FROM data WHERE id = ?", id);
    }
}
