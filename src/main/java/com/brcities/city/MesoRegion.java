package com.brcities.city;

public class MesoRegion {
    private final String name;
    private final State state;

    public MesoRegion(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }
}
