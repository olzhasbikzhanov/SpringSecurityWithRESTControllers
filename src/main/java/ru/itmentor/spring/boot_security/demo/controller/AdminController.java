package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;

    @Autowired
    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> indexUser() {
        return userService.indexUser();
    }

    @GetMapping("/{id}")
    public User show(@PathVariable("id") int id) {
        return userService.show(id);
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "admin/new";
    }

//    @PostMapping("/new")
    @PostMapping
    public List<User> create(@RequestBody User user) {
        userService.save(user);
        return userService.indexUser();
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public List<User> update(@RequestBody User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return userService.indexUser();
    }

    @DeleteMapping("/{id}")
    public List<User> delete(@PathVariable("id") int id) {
        userService.delete(id);
        return userService.indexUser();
    }
}
