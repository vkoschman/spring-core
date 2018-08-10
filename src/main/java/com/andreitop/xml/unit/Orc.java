package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Mount;

public class Orc implements Unit {

    private Mount mount;
    private String weapon;
    private int colorCode;

    public Orc(Mount mount) {
        this.mount = mount;
    }

    @Override
    public void mountMove() {
        mount.move();
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public Mount getMount() {
        return mount;
    }
}




