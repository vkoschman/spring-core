package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Mount;

public class Human implements Unit {

    private Mount mount;
    private String weapon;

    public Human(Mount mount, String weapon) {
        this.mount = mount;
        this.weapon = weapon;
    }

    @Override
    public void mountMove() {
        mount.move();
    }

    public String getWeapon() {
        return weapon;
    }

    public Mount getMount() {
        return mount;
    }
}




