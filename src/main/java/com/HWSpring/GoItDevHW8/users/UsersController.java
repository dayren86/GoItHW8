package com.HWSpring.GoItDevHW8.users;

import com.HWSpring.GoItDevHW8.users.roles.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/users")
@Controller
public class UsersController {
    private final UsersService usersService;
    private final RolesService rolesService;

    @GetMapping
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", usersService.getAllUsers());
        modelAndView.addObject("roles", rolesService.getAllRoles());
        return modelAndView;
    }

    @PostMapping("/add")
    public void createUsers(@RequestParam(name = "usersEmail") String email,
                            @RequestParam(name = "usersPassword") String password,
                            @RequestParam(name = "usersFirstName") String firsName,
                            @RequestParam(name = "usersLastName") String lastName,
                            @RequestParam(name = "roles") UUID uuid,
                            HttpServletResponse response) {

        usersService.create(email, password, firsName, lastName, uuid);

        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/update")
    public void updateUsers(@RequestParam(name = "updateUsersUUID") UUID uuidUsers,
                            @RequestParam(name = "updateUsersEmail") String email,
                            @RequestParam(name = "updateUsersPassword") String password,
                            @RequestParam(name = "updateUsersFirstName") String firsName,
                            @RequestParam(name = "updateUsersLastName") String lastName,
                            @RequestParam(name = "updateUsersRoles") UUID uuidRoles,
                            HttpServletResponse response) {


        usersService.update(uuidUsers, email, password, firsName, lastName, uuidRoles);

        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/delete")
    public void createUsers(@RequestParam(name = "deleteUsers") UUID uuid,
                            HttpServletResponse response) {

        usersService.delete(uuid);

        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
