package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Wolf;

public class Orc implements Unit {

    private Wolf wolf;

    public Orc() {
        wolf = new Wolf();
    }

    @Override
    public void mountMove() {
        wolf.move();
    }
}




