package com.gmail.sicyaas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Save {
}

class Country {
    @Save
    String theName;
    String[] biggestCities;
    @Save
    Integer population;
    Boolean isEmperorPresent;

    public Country() {
    }

    public Country(String theName, String[] biggestCities, Integer population, Boolean isEmperorPresent) {
        this.theName = theName;
        this.biggestCities = biggestCities;
        this.population = population;
        this.isEmperorPresent = isEmperorPresent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "theName='" + theName + '\'' +
                ", biggestCities=" + Arrays.toString(biggestCities) +
                ", population=" + population +
                ", isEmperorPresent=" + isEmperorPresent +
                '}';
    }
}


public class Main {
    public static void main(String[] args) throws IllegalAccessException, FileNotFoundException {

        Country japan = new Country("Japan", new String[]{"Tokyo", "Osaka", "Nagoya"}, 125_360_000, true);
        File fl = new File("C:\\Users\\Velvet X\\Documents\\Java Studies\\Java Pro\\ReflectionSample\\test.txt");
        serializer(japan, fl.getAbsolutePath());
        Country test = deSerializer(fl);


        System.out.println(test);


    }


    public static Country deSerializer(File file) throws FileNotFoundException, IllegalAccessException {
        Country test = new Country();
        String[] readFields = fileReader(file).split(System.lineSeparator());
        Class<?> cls = Country.class;
        for (String temp : readFields) {
            String[] strArr = temp.split("=");
            Field field;
            try {
                field = cls.getDeclaredField(strArr[0]);
            } catch (NoSuchFieldException e) {
                continue;
            }
            if (field.getType() == String.class) {
                field.set(test, strArr[1]);
            } else if (field.getType() == Integer.class) {
                field.set(test, Integer.parseInt(strArr[1]));
            }
        }
        return test;
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

    public static String fileReader(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String result = "";
        for (; sc.hasNextLine(); ) {
            result = result + sc.nextLine() + System.lineSeparator();
        }
        return result;
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
