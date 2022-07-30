package school21.spring.service.models;

import java.util.List;
import java.util.StringJoiner;

public class User {

    private Long    id;

    private String  email;

    public User (Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("email='" + email + "'")
                .toString();
    }
}
