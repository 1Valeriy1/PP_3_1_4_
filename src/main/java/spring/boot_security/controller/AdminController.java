package spring.boot_security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.boot_security.models.User;
import spring.boot_security.service.RoleService;
import spring.boot_security.service.UserService;

import java.security.Principal;


@Controller
public class AdminController {

    private final UserService service;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService service, RoleService roleService ) {
        this.service = service;
        this.roleService = roleService;
    }
//таблица юзеров
    @GetMapping("/admin")
    public String users(Model model, Principal principal, @ModelAttribute("user") User user){
        model.addAttribute("admin", service.getUserByName(principal.getName()));
        model.addAttribute("users", service.listUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roleService.getRoles());
        return "/admin";
    }
//сохранение юзера
    @GetMapping("/admin/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getRoles());
        return "/admin/add";
    }

    @PostMapping("/admin/save")
    public String save(@ModelAttribute("user") User user) {
        service.add(user);
        return "redirect:/admin";
    }
//изменеие юзера
    @PutMapping("/admin/update")
    public String update(@ModelAttribute("user") User user) {
        service.add(user);
        return "redirect:/admin";
    }

// поиск по id юзера
    @GetMapping("/admin/find/{id}")
    public String find(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "/admin/update";
    }
// удаление юзера
    @DeleteMapping("/admin/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/admin";
    }
}

