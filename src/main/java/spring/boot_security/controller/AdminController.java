package spring.boot_security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.boot_security.models.User;
import spring.boot_security.service.UserService;


@Controller
public class AdminController {

    private final UserService service;

    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }
//таблица юзеров
    @GetMapping("/admin")
    public String users(Model model){
        model.addAttribute("users", service.listUsers());
        model.addAttribute("user", new User());
        return "/admin";
    }
//сохранение юзера
    @GetMapping("/admin/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
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

