package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id")Long id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "/currentUser";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")Long id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "/edit";


    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")User user,@PathVariable("id")Long id){
        userService.update(id,user);
        return "redirect:/users";
    }



    @GetMapping("/add")
    public String addUser(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "add_user";
    }




    @DeleteMapping("/{id}")
public String deleteUser(@PathVariable("id") Long id) {
    userService.delete(id);
    return "redirect:/users";
}




    @PostMapping ("/users")
    public String saveUser(@ModelAttribute("user")User user) {
        userService.save(user);
        return "saveUser";

    }
}



