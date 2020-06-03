package jv.spring.service;

import java.util.List;
import jv.spring.model.User;

public interface UserService {
    User add(User user);

    List<User> listUsers();
}
