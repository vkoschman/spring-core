package com.andreitop.xml;

import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class XmlConfigurationTest {

    private static ApplicationContext ctx;

    @BeforeClass
    public static void init() {
        ctx = new ClassPathXmlApplicationContext("mount-context.xml");
    }

    @Test
    public void testWolfBeanCreation() {
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Wolf.class)), containsString("frostWolf"));
    }

    @Test
    public void testTigerBeanCreation() {
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Tiger.class)), containsString("shadowTiger"));
    }

}
