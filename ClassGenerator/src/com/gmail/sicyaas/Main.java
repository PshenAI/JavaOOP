package com.gmail.sicyaas;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File file = new File("Country.json");

        ClassGenerator clsGen = new ClassGenerator(file);
        try {
            clsGen.classCreator();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
