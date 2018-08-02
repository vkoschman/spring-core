package com.andreitop.di.unit;

import com.andreitop.di.mount.Wolf;

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




