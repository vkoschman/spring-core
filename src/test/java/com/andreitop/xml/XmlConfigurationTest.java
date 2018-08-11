package com.andreitop.xml;

import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import com.andreitop.xml.unit.Human;
import com.andreitop.xml.unit.Orc;
import com.andreitop.xml.unit.Troll;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hamcrest.collection.IsMapContaining;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class XmlConfigurationTest {

    private static ApplicationContext ctx;
    private static Human human;
    private static Orc orc;
    private static Troll troll;

    @BeforeClass
    public static void init() {
        ctx = new ClassPathXmlApplicationContext("heroes-context.xml", "advanced-context.xml");
        human = ctx.getBean("knight", Human.class);
        orc = (Orc) ctx.getBean("trall");
        troll = ctx.getBean("zulJin", Troll.class);
    }

    @Test
    public void testMountBeanCreation() {
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Wolf.class)), containsString("frostWolf"));
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Tiger.class)), containsString("shadowTiger"));
    }

    @Test
    public void testUnitBeanCreation() {
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Human.class)), containsString("knight"));
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Orc.class)), containsString("trall"));
        assertThat(Arrays.deepToString(ctx.getBeanNamesForType(Troll.class)), containsString("zulJin"));
    }

    @Test
    public void testHumanConstructor() {
        assertThat(human.getLeftHandWeaponWeapon(), equalToIgnoringCase("thunderfury"));
        assertThat(human.getRightHandWeaponWeapon(), equalToIgnoringCase("soulblade"));
        assertThat(human.getMount(), instanceOf(Tiger.class));
    }

    @Test
    public void testOrcCharacteristics() {
        assertThat(orc.getMount(), instanceOf(Wolf.class));
        assertThat(orc.getWeapon(), equalToIgnoringCase("furryaxe"));
        assertThat(orc.getColorCode(), equalTo(9));
    }

    @Test
    public void testTrollCollectionSize() {
        troll.mountMove();
        assertThat(troll.getListOfMounts(), hasSize(3));
        assertThat(troll.getSetOfMounts(), hasSize(2));
        assertThat(troll.getMapOfMounts().size(), is(2));
    }

    @Test
    public void testTrollCollectionElements() {
        assertThat(troll.getListOfMounts(), hasItem(isA(Wolf.class)));
        assertThat(troll.getListOfMounts(), hasItems(null, ctx.getBean("shadowTiger",Tiger.class)));

        assertThat(troll.getSetOfMounts(), contains(ctx.getBean("shadowTiger",Tiger.class), ctx.getBean("frostWolf",Wolf.class)));

        assertThat(troll.getMapOfMounts(),IsMapContaining.hasEntry("m1", ctx.getBean("frostWolf")));
        assertThat(troll.getMapOfMounts(),IsMapContaining.hasEntry("m2", ctx.getBean("shadowTiger")));
    }

    @Test
    public void testTrollCreationDate() {
        assertThat(troll.getCreationDate().toString(), containsString("2004"));
    }
}
