package com.andreitop.xml;

import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import com.andreitop.xml.unit.Human;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class XmlConfigurationTest {

    private static ApplicationContext ctx;
    private static Human human;

    @BeforeClass
    public static void init() {
        ctx = new ClassPathXmlApplicationContext("heroes-context.xml");
        human = ctx.getBean("knight", Human.class);
    }

    @Test
    public void testWolfBeanCreation() {
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Wolf.class)), containsString("frostWolf"));
    }

    @Test
    public void testTigerBeanCreation() {
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Tiger.class)), containsString("shadowTiger"));
    }

    @Test
    public void testHumanConstructor() {
        assertThat(human.getWeapon(), equalToIgnoringCase("magicsword"));
        assertThat(human.getMount(), instanceOf(Tiger.class));
    }

}
