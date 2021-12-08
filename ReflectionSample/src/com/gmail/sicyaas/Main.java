package com.gmail.sicyaas;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Save {
}

class Country {
    @Save
    String theName;
    @Save
    Integer population;
    Boolean isEmperorPresent;

    public Country() {
    }

    public Country(String theName, Integer population, Boolean isEmperorPresent) {
        this.theName = theName;
        this.population = population;
        this.isEmperorPresent = isEmperorPresent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "theName='" + theName + '\'' +
                ", population=" + population +
                ", isEmperorPresent=" + isEmperorPresent +
                '}';
    }
}


public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        Country japan = new Country("Japan", 125_360_000, true);
        File fl = new File("C:\\Users\\Velvet X\\Documents\\Java Studies\\Java Pro\\ReflectionSample\\test.txt");
        serializer(japan, fl.getAbsolutePath());
        Country test = deSerializer(fl);

        System.out.println(test);


    }


    public static Country deSerializer(File file) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Map<String, String> test = fileReader(file);
        Country country = new Country();

        Class<?> cls = Country.class;
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            String temp = test.get(field.getName());
            Constructor<?> ctr = field.getType().getConstructor(String.class);
            if(temp != null){
                field.set(country, ctr.newInstance(temp));
            }
        }
        return country;
    }

    public static void serializer(Country country, String path) throws IllegalAccessException {
        Map<String, String> classFields = new HashMap<>();
        Class<?> cls = Country.class;
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                String fieldName = field.getName();
                String fieldValue = String.valueOf(field.get(country));
                classFields.put(fieldName, fieldValue);
            }
        }
        fileWriter(classFields, path);
    }

    public static Map<String, String> fileReader(File file) {
        String text = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String temp = "";
            while ((temp = br.readLine()) != null) {
                text = text + temp + System.lineSeparator();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] split = text.split(System.lineSeparator());
        Map<String, String> fields = new HashMap<>();
        for (String field : split){
            String[] temp = field.split("=");
            fields.put(temp[0], temp[1]);
        }
        return fields;
    }

    public static void fileWriter(Map<String, String> fields, String path) {
        Set<Map.Entry<String, String>> testSet = fields.entrySet();
        try (PrintWriter pw = new PrintWriter(path)) {
            for (Map.Entry<String, String> field : testSet) {
                pw.println(field);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
