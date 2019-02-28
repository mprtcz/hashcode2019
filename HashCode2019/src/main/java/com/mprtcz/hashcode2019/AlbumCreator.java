package com.mprtcz.hashcode2019;


import java.util.*;

public class AlbumCreator {

    List<String> solve(Map<String, Set<String>> map) {
        List<String> list = new LinkedList<>();

        for(Iterator<Map.Entry<String, Set<String>>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Set<String>> entry = it.next();
            list.add(entry.getKey());
            it.remove();
            Map.Entry<String, Set<String>> highest = null;
            int actualMin = 0;



            for(Iterator<Map.Entry<String, Set<String>>> it2 = map.entrySet().iterator(); it2.hasNext(); ) {
                Map.Entry<String, Set<String>> entry2 = it2.next();
                if(highest == null) {
                    highest = entry2;
                    actualMin = getMin(entry.getValue(), entry2.getValue());
                } else if(actualMin < getMin(entry.getValue(), entry2.getValue())) {
                    highest = entry2;
                    actualMin = getMin(entry.getValue(), entry2.getValue());
                }
            }
            list.add(highest.getKey());
        }
        return list;
    }









    List<String> solve2(LinkedHashMap<String, Set<String>> map) {
        LinkedList<String> list = new LinkedList<>();

        Map.Entry<String, Set<String>> temp = map.entrySet().iterator().next();
        list.add(temp.getKey());
        for(Iterator<Map.Entry<String, Set<String>>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Set<String>> entry = it.next();
            it.remove();
            Map.Entry<String, Set<String>> highest = null;
            int actualMin = 0;
            String lastentry = list.getLast();
            for(Iterator<Map.Entry<String, Set<String>>> it2 = map.entrySet().iterator(); it2.hasNext(); ) {
                Map.Entry<String, Set<String>> entry2 = it2.next();
                if(highest == null) {
                    highest = entry2;
                    actualMin = getMin(map.get(lastentry), entry2.getValue());
                } else if(actualMin < getMin(map.get(lastentry), entry2.getValue())) {
                    highest = entry2;
                    actualMin = getMin(map.get(lastentry), entry2.getValue());
                }
            }
            list.add(highest.getKey());
        }
        return list;
    }

    Integer getMin(Set<String> slide1, Set<String> slide2) {
        int first = 0;
        int both = 0;
        int second = 0;

        Set<String> copy2 = new HashSet<>(slide2);
        for(String tag1 : slide1) {
            if(copy2.contains(tag1)) {
                both++;
                copy2.remove(tag1);
            } else {
                first++;
            }
        }
        second = copy2.size();


        return Math.min(Math.min(first, both), second);
    }
}
