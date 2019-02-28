package com.mprtcz.hashcode2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) throws IOException {
    int id = -1;
    try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\dqnx67\\Learning\\hashcode2019\\HashCode2019\\src\\main\\resources\\a_example.txt"))) {

      Map<Integer, Set<String>> verticals = new HashMap<>();
      Map<String, Set<String>> horizontals = new HashMap<>();


      lines.forEach(line -> {
        String[] tab = line.split(" ");
        if(tab[0].equals("H")) {
          
        } else {

        }
      });


      lines.forEach(System.out::println);
    }
  }


}
