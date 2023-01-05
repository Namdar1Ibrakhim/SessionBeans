package com.example.beansession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {
    //Бин имеет область видимости в рамках Сессии то есть
    // Если его будети вызывать один и тот же Бин то экземпляр будет один и тот же
    // каждому пользователю свой бин в рамках всей сессии
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
