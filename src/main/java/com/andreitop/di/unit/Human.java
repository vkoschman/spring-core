package com.andreitop.di.unit;

import com.andreitop.di.mount.Mount;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class Human implements Unit {

    @Inject
    @Qualifier("wolf")
    private Mount mount;

    @Override
    public void mountMove() {
        mount.move();
    }

    public Mount getMount() {
        return mount;
    }
}




