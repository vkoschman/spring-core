package com.andreitop.di.mount;

import org.springframework.stereotype.Component;

@Component
public class Wolf implements Mount {
    public void move() {
        System.out.println("I'm a wolf!");
    }
}
