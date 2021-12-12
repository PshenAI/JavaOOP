package com.gmail.sicyaas;

public class Country {

    public Boolean isMonarchPresent;
    public String theName;
    public Integer population;


    public Country() {
    }

    public Country(Boolean isMonarchPresent, String theName, Integer population) {
        this.isMonarchPresent = isMonarchPresent;
        this.theName = theName;
        this.population = population;
    }
}
