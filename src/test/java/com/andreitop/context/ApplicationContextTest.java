package com.andreitop.context;

import com.andreitop.di.mount.Wolf;
import com.andreitop.di.unit.Human;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class ApplicationContextTest {

    @Test
    public void testClassPathXmlApplicationContext() {
        //classpath, paths, multiple resources
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resource-context.xml");
        Human human = (Human) ctx.getBean("human");
        assertThat(human.getMount(), instanceOf(Wolf.class));
    }

    @Test
    public void testFileSystemXmlApplicationContext() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:com/andreitop/context/simple-context.xml");
        Human human = (Human) ctx.getBean("human");
        assertThat(human.getMount(), instanceOf(Wolf.class));
    }

    @Test
    public void testGenericApplicationContext() {
        GenericApplicationContext ctx = new GenericApplicationContext();
        new XmlBeanDefinitionReader(ctx).loadBeanDefinitions(new String[]{"parent.child/rfolder-context.xml"});
        ctx.refresh();
        Human human = (Human) ctx.getBean("human");
        assertThat(human.getMount(), instanceOf(Wolf.class));
    }

}
