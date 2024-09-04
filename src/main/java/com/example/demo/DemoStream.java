package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DemoStream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aZe");
        list.add("EAZLDSJaze");

        Stream<String> stream = list.stream()
                .map(String::toLowerCase);
        List<String> str =stream.toList();
    }
}
