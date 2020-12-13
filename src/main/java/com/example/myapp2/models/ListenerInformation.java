package com.example.myapp2.models;

public class ListenerInformation {
    private Listener listener;
    private String name;

    public ListenerInformation(Listener listener, String name) {
        this.listener = listener;
        this.name = name;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
