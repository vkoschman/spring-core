package com.andreitop.xml;

import com.andreitop.xml.mount.Tiger;
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
    public void testCreatedTigerBean() {
        assertThat(ctx.getBeanNamesForType(Tiger.class).length, is(6));
        assertThat(ctx.getBeanNamesForType(Tiger.class),
                arrayContainingInAnyOrder("$",
                        "tiger00",
                        "tiger01",
                        "tiger02/tiger03",
                        "tiger04; tiger05",
                        "tiger04"));

    }

    @Test
    public void testTigerBeanDefinitions() {
        assertThat(ctx.getBeanDefinitionCount(), is(7));
        assertThat(Arrays.asList(ctx.getBeanDefinitionNames()),
                hasItems("$",
                        "tiger00",
                        "tiger01",
                        "tiger02/tiger03",
                        "tiger04; tiger05",
                        "tiger04"));
        assertThat(Arrays.asList(ctx.getBeanDefinitionNames()), hasItem(startsWith("com.andreitop.xml.mount.Tiger")));
    }

    @Test
    public void testTigerBeanAliases() {
        assertThat(ctx.getAliases("tiger04"), arrayContainingInAnyOrder("tiger05","tiger004","tiger005"));
        assertThat(ctx.getAliases("tiger01"), arrayContainingInAnyOrder("tiger02"));
        assertThat(ctx.getAliases("tiger02/tiger03"), arrayContainingInAnyOrder("shadowTiger"));
    }


    @Test
    public void testTigerBeanAnnotatedConfig() {
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Tiger.class)), containsString("spectralTiger"));
    }

}
