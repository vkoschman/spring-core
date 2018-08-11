package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Wolf;

import java.util.*;
import java.util.stream.Stream;


public class Troll implements Unit {
    private List<Mount> listOfMounts;
    private Set<Mount> setOfMounts;
    private Map<String, Mount> mapOfMounts;
    private Date creationDate;
    public static final Mount DEFAULT_MOUNT = new Wolf();
    private int colorCode;

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setListOfMounts(List<Mount> listOfMounts) {
        this.listOfMounts = listOfMounts;
    }

    public void setSetOfMounts(Set<Mount> setOfMounts) {
        this.setOfMounts = setOfMounts;
    }

    public void setMapOfMounts(Map<String, Mount> mapOfMounts) {
        this.mapOfMounts = mapOfMounts;
    }

    public List<Mount> getListOfMounts() {
        return listOfMounts;
    }

    public Set<Mount> getSetOfMounts() {
        return setOfMounts;
    }

    public Map<String, Mount> getMapOfMounts() {
        return mapOfMounts;
    }

    @Override
    public void mountMove() {
        mapOfMounts.forEach((k, v) -> {
            System.out.print("key=" + k + " ");
            v.move();
        });
        Stream.of(listOfMounts,setOfMounts)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .forEach(Mount::move);

    }
}
