package com.andreitop.xml.config;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import com.andreitop.xml.unit.Human;
import com.andreitop.xml.unit.Orc;
import com.andreitop.xml.unit.Troll;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.andreitop.xml.unit.Troll.DEFAULT_MOUNT;

@Configuration
@ComponentScan(basePackages = "com.andreitop.xml")
@PropertySource("classpath:config/heroes.properties")
public class AppConfig {
    @Value("${character.created}")
    private String date;

    @Bean
    public Mount shadowTiger() {
        return new Tiger();
    }

    @Bean
    public Mount frostWolf() {
        return new Wolf();
    }

    @Bean
    public Human knight() {
        return new Human(shadowTiger(), "thunderFury", "soulBlade");
    }

    @Bean
    public Orc trall() {
        Orc orc = new Orc(frostWolf());
        orc.setWeapon("furryAxe");
        orc.setColorCode(9);
        return orc;
    }

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("config/heroes.properties"));
        return  propertyPlaceholderConfigurer;
    }

    @Bean
    public HashMap<String, Mount> trollMountMap() {
        HashMap<String, Mount> map = new HashMap<>();
        map.put("m1", frostWolf());
        map.put("m2", shadowTiger());
        return map;
    }

    @Bean
    public Set<Mount> trollMountSet() {
        Set<Mount> set= new LinkedHashSet<>();
        set.add(shadowTiger());
        set.add(frostWolf());
        return set;
    }

    @Bean
    public SimpleDateFormat dateFormatter(){
        return new SimpleDateFormat("dd-mm-yyyy");
    }

    @SneakyThrows
    @Bean
    public Troll zulJin() {
        Troll troll = new Troll();

        Random random = new Random();
        int num = 1 + random.nextInt(10 - 1);

        troll.setColorCode(num);
        troll.setCreationDate(dateFormatter().parse(date));
        troll.setMapOfMounts(trollMountMap());
        troll.setSetOfMounts(trollMountSet());

        List<Mount> list = new ArrayList<>();
        list.add(DEFAULT_MOUNT);
        list.add(null);
        list.add(shadowTiger());
        troll.setListOfMounts(list);

        return troll;
    }
}
