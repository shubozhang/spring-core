package spring.core.di.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.core.di.annotation.TestObject;
import spring.core.di.annotation.service.UserService;


@Controller
public class UserController {
  /*  @Autowired(required = false) // This bean does not have to be defined in config file.
    private TestObject testObject;

    @Autowired // This bean must be defined in config file
    private UserService userService;

    public void execute() {
        System.out.println("UserController execute method---");
        userService.add();
    }*/
}
