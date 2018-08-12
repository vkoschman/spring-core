package com.andreitop.xml.mount;

import org.springframework.stereotype.Component;

@Component("spectralTiger")
public class Tiger implements Mount {
    public void move() {
        System.out.println("I'm a tiger!");
    }
}
