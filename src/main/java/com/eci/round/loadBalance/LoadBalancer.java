package com.eci.round.loadBalance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class LoadBalancer {
    final List<String> ipList;

    public LoadBalancer() {
        List <String> list = new ArrayList<>();
        list.add("http://localhost:35001");
        list.add("http://localhost:35002");
        list.add("http://localhost:35003");
        this.ipList = Collections.unmodifiableList(list);
    }

    abstract String getIp();
}
