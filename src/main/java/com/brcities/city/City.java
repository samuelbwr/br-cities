package com.brcities.city;

import java.text.Normalizer;

public class City {
    private Long ibgeId;
    private String name;
    private boolean capital;
    private Double lat;
    private Double lon;
    private String alternativeName;
    private MicroRegion microRegion;

    public City(Long ibgeId, String name, boolean capital, Double lat, Double lon, String alternativeName, MicroRegion microRegion) {
        this.ibgeId = ibgeId;
        this.name = name;
        this.capital = capital;
        this.lat = lat;
        this.lon = lon;
        this.alternativeName = alternativeName;
        this.microRegion = microRegion;
    }

    public String getNoAccentName(){
        return Normalizer.normalize( name, Normalizer.Form.NFC );
    }

    public Long getIbgeId() {
        return ibgeId;
    }

    public String getName() {
        return name;
    }

    public boolean isCapital() {
        return capital;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public MicroRegion getMicroRegion() {
        return microRegion;
    }
}
