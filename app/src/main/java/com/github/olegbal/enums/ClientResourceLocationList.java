package com.github.olegbal.enums;

public enum ClientResourceLocationList {
    angular("classpath:/static/angular/", 0),
    react("classpath:/static/react/", 1);
    public String path;
    public int id;

    ClientResourceLocationList(String s, int i) {
        this.path = s;
        this.id = i;
    }
}
