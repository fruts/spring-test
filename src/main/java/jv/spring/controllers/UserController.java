package jv.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;
import jv.spring.dto.UserResponseDto;
import jv.spring.model.User;
import jv.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String injectData() {
        userService.add(new User("dimon@gmail.com", "1234"));
        userService.add(new User("sanya@gmail.com", "1234"));
        userService.add(new User("serega@gmail.com", "1234"));
        userService.add(new User("lomonosov@gmail.com", "1234"));
        return "Success";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return getUserDto(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<User> users = userService.listUsers();
        return users.stream()
                .map(this::getUserDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto getUserDto(User user) {
        var userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
