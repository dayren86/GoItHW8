package com.HWSpring.GoItDevHW8.users.roles;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.stereotype.Component;
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
@RequestMapping("/roles")
@Controller
public class RolesController {
    private final RolesService rolesService;

    @GetMapping
    public ModelAndView getAllRoles() {
        ModelAndView modelAndView = new ModelAndView("roles");
        modelAndView.addObject("rolesList", rolesService.getAllRoles());
        return modelAndView;
    }

    @PostMapping("/add")
    public void createRoles(@RequestParam(name = "rolesName") String name,
                            HttpServletResponse response) {

        rolesService.create(name);

        try {
            response.sendRedirect("/roles");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/delete")
    public void deleteRoles(@RequestParam(name = "deleteRoles") UUID uuid,
                            HttpServletResponse response) {

        rolesService.delete(uuid);

        try {
            response.sendRedirect("/roles");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/update")
    public void updateRoles(@RequestParam(name = "updateUUID") UUID uuid,
                            @RequestParam(name = "updateRolesName") String name,
                            HttpServletResponse response) {

        rolesService.update(uuid, name);

        try {
            response.sendRedirect("/roles");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
