package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Mount;

public class Human implements Unit {

    private Mount mount;
    private String leftHandWeapon;
    private String rightHandWeapon;

    public Human(Mount mount, String leftHandWeapon, String rightHandWeapon) {
        this.mount = mount;
        this.leftHandWeapon = leftHandWeapon;
        this.rightHandWeapon = rightHandWeapon;
    }

    @Override
    public void mountMove() {
        mount.move();
    }

    public String getLeftHandWeaponWeapon() {
        return leftHandWeapon;
    }

    public String getRightHandWeaponWeapon() {
        return rightHandWeapon;
    }

    public Mount getMount() {
        return mount;
    }
}




