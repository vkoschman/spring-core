package com.andreitop.di.unit;

import com.andreitop.di.mount.Mount;

public class Human implements Unit {

    private Mount mount;

    public Human(Mount mount) {
        this.mount = mount;
    }

    @Override
    public void mountMove() {
        mount.move();
    }
}




