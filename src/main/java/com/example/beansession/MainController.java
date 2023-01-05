package com.example.beansession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    //Контроллер получает параметр запроса о выходе из приложения
    //и передает в представление имя пользователя, где оно будет
    //выведено из веб страницы

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public MainController(
            LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String Logout,
            Model model
    ) {
        if (Logout != null) { //то есть когда ссылка нажалась в html это значит она не null
            //и это значит чел намерен выйти с акаунта тогда username = null;
            loggedUserManagementService.setUsername(null);
        }
        //Если username = null то перекидывает на этот путь
        String username = loggedUserManagementService.getUsername();
        if (username == null) {
            return "redirect:/";
        }
        int count = loginCountService.getCount();

        //иначе значит что человек заходит в аккаунт и у него есть username
        model.addAttribute("username" , username);
        model.addAttribute("loginCount", count);
        return "main.html";
    }
}
