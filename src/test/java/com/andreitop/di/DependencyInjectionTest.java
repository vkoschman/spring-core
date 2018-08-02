package com.andreitop.di;

import com.andreitop.di.mount.Tiger;
import com.andreitop.di.mount.Wolf;
import com.andreitop.di.unit.Human;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;


public class DependencyInjectionTest {

    private static Human human;

    @BeforeClass
    public static void init() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        human = (Human) ctx.getBean("human");
    }

    @Test
    public void humanHasTigerMount() {
        assertThat(human.getMount(), instanceOf(Tiger.class));
    }

    @Test
    public void humanHasWolfMount() {
        assertThat(human.getMount(), instanceOf(Wolf.class));
    }
}