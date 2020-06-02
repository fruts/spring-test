package jv.spring;

import jv.spring.config.AppConfig;
import jv.spring.model.User;
import jv.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("user", "email", "123"));

        userService.listUsers().forEach(System.out::println);
    }
}
