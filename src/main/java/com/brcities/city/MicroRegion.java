package com.brcities.city;

public class MicroRegion {
    String name;
    MesoRegion mesoRegion;

    public MicroRegion(String name, MesoRegion mesoRegion) {
        this.name = name;
        this.mesoRegion = mesoRegion;
    }

    public String getName() {
        return name;
    }

    public MesoRegion getMesoRegion() {
        return mesoRegion;
    }
}
