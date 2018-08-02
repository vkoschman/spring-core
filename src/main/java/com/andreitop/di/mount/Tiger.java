package com.andreitop.di.mount;

import org.springframework.stereotype.Component;

@Component
public class Tiger implements Mount {
    public void move() {
        System.out.println("I'm a tiger!");
    }
}
