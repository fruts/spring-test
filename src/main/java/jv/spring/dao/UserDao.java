package jv.spring.dao;

import java.util.List;
import jv.spring.model.User;

public interface UserDao {
    User add(User user);

    List<User> listUsers();
}
