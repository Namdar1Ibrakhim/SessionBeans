package com.example.beansession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //Нужен чтобы перенаправить человека на главную страницу
    //при успешном аутентификации

    LogginProcessor loginProcessor;

    public LoginController(LogginProcessor logginProcessor){
        this.loginProcessor = logginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        if (loggedIn) {
            return "redirect:/main";
        }
        //После успешной аутентификации приложение перенаправляет
        //пользователя на главную страницу

        model.addAttribute("message", "Login failed!");
        return "login.html";
    }
}

