package com.brcities.city.model;

public class MicroRegion {
    private final String name;
    private final MesoRegion mesoRegion;

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
