package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Mount;

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




