package com.gmail.sicyaas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.Arrays;

class Book {
    String name;
    int pages;
    String author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                '}';
    }
}

class Library {
    Book[] books;

    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                '}';
    }
}

public class Main {

    static String TEST_JSON = """
                {
                  "books": [
                     {
                        "name": "The Call of Ctulhu",
                        "pages": 420,
                        "author": "H.P.Lovecraft"
                     },
                     {
                        "name": "Nikolai Gogol",
                        "pages": 200,
                        "author": "Viy"
                     }
                  ]
                }
            """;

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Library library = gson.fromJson(TEST_JSON, Library.class);

        System.out.println(library);

    }
}
