package com.mprtcz.hashcode2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

//C:\Users\dqnx67\Learning\hashcode2019\HashCode2019\src\main\resources\
public class App {
    Map<Integer, Set<String>> verticals = new HashMap<>();
    Map<String, Set<String>> horizontals = new TreeMap<>();
    Map<String, List<Integer>> indexesForTags = new HashMap<>();

    Map<String, Set<String>> slides = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.readContent();
        //app.sort();
        System.out.println(AlbumCreator.solve(app.horizontals));
    }

    private void readContent() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\dqnx67\\Learning\\hashcode2019\\HashCode2019\\src\\main\\resources\\c_memorable_moments.txt"))) {
            List<String> lineLists = lines.collect(Collectors.toList());

            for(int i = 1; i < lineLists.size(); i++) {
                List<String> tab = Arrays.asList(lineLists.get(i).split(" "));
                Set<String> tags = new HashSet<>(tab.subList(2, tab.size()));
                if (tab.get(0).equals("H")) {
                    horizontals.put(String.valueOf(i), tags);
                } else {
                    verticals.put(i, tags);
                }
            }

            for(Map.Entry<Integer, Set<String>> entry : verticals.entrySet()) {
                for(String tag : entry.getValue()) {
                    if(indexesForTags.containsKey(tag)) {
                        indexesForTags.get(tag).add(entry.getKey());
                    } else {
                        indexesForTags.put(tag, new ArrayList<>(Arrays.asList(entry.getKey())));
                    }
                }
            }
            //System.out.println(verticals);
            //System.out.println(horizontals);
            //System.out.println(indexesForTags);
        }
    }

    void sort() {
        horizontals.entrySet().stream()
                .sorted(comparingInt(e -> -e.getValue().size()))
                .forEachOrdered(x -> slides.put(x.getKey(), x.getValue()));

        slides.entrySet().forEach(entry -> System.out.println(entry.getValue().size()));
    }

}
