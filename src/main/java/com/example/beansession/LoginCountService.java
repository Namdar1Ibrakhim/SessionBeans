package com.example.beansession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope //область видимости бина в рамка веб-приложения
//работает как одиночный бин, один бин используют много запросов
public class LoginCountService{
    private int count;

    public void increment(){
        count++;
        System.out.println(count);
    }
    public int getCount(){
        return count;
    }
}
