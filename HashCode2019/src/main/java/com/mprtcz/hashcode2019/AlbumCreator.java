package com.mprtcz.hashcode2019;


import java.util.*;

public class AlbumCreator {

    static List<String> solve(Map<String, Set<String>> map) {
        LinkedList<String> list = new LinkedList<>();

        Map.Entry<String, Set<String>> temp = map.entrySet().iterator().next();
        list.add(temp.getKey());
        int index = 0;
        for(Iterator<Map.Entry<String, Set<String>>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Set<String>> entry = it.next();

            index++;
            System.out.println((index* 100) / map.size());
            Map.Entry<String, Set<String>> highest = null;
            int actualMin = 0;
            String lastentry = list.getLast();
            Map.Entry<String, Set<String>> temp1 = entry;
            it.remove();
            for(Iterator<Map.Entry<String, Set<String>>> it2 = map.entrySet().iterator(); it2.hasNext(); ) {
                Map.Entry<String, Set<String>> entry2 = it2.next();
                if(highest == null) {
                    actualMin = getMin(temp1.getValue(), entry2.getValue());
                    highest = entry2;
                } else if(actualMin < getMin(temp1.getValue(), entry2.getValue())) {
                    highest = entry2;
                    actualMin = getMin(temp1.getValue(), entry2.getValue());
                }
            }
            if(highest != null) {
                list.add(highest.getKey());
            }

        }
        return list;
    }

    static Integer getMin(Set<String> slide1, Set<String> slide2) {
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
