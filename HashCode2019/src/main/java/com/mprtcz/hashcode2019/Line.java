package com.mprtcz.hashcode2019;

import java.util.Set;

public class Line {

    int id;
    Type type;
    Set<String> tags;

    public Line(int id, Type type, Set<String> tags) {
        this.id = id;
        this.type = type;
        this.tags = tags;
    }
}
