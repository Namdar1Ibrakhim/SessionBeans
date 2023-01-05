package com.example.beansession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LogginProcessor{
    // реализована логика проверки
    // Бин имеет область видимости в рамках запроса то есть при каждом запросе создается
    // новый экземпляр бина(этого класса в контексте спринг)
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    public LogginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login() {
        loginCountService.increment();
        //Увеличение счетчика попыток аутентификации при каждом запросе на аутентификацию

        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;
        if ("ibra".equals(username) && "ibra".equals(password)) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
            //если пароль и данные верны то username присваивается имя то что он зашел на акк
        }
        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
