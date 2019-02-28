package com.mprtcz.hashcode2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) throws IOException {
    int id = -1;
    try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\dqnx67\\Learning\\hashcode2019\\HashCode2019\\src\\main\\resources\\a_example.txt"))) {

      List<Line> pictures = lines.map(line -> {
        
        String[] tab = line.split(" ");
        Line temp = new Line();

      }).collect(Collectors.toList());
      lines.forEach(System.out::println);
    }
  }


}
