package com.mprtcz.hashcode2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\dqnx67\\Learning\\hashcode2019\\HashCode2019\\src\\main\\resources\\a_example.txt"))) {
            List<String> lineLists = lines.collect(Collectors.toList());
            Map<Integer, Set<String>> verticals = new HashMap<>();
            Map<String, Set<String>> horizontals = new HashMap<>();


            for(int i = 1; i < lineLists.size(); i++) {
                List<String> tab = Arrays.asList(lineLists.get(i).split(" "));
                Set<String> tags = new HashSet<>(tab.subList(2, tab.size()));
                if (tab.get(0).equals("H")) {
                    horizontals.put(String.valueOf(i), tags);
                } else {
                    verticals.put(i, tags);
                }
            }
            System.out.println(verticals);
            System.out.println(horizontals);
        }
    }


}
