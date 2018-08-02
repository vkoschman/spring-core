package com.andreitop.di.unit;

import com.andreitop.di.mount.Mount;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class Human implements Unit {

    private Mount mount;

    @Inject
    public Human(Mount mount) {
        this.mount = mount;
    }

    @Override
    public void mountMove() {
        mount.move();
    }

    public Mount getMount() {
        return mount;
    }
}




