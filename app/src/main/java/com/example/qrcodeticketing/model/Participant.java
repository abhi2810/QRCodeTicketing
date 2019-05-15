package com.example.qrcodeticketing.model;

public class Participant {
    private String id;
    private String name;
    private String email;
    private boolean scanned;

    public Participant(String id, String name, String email, boolean scanned) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.scanned = scanned;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isScanned() {
        return scanned;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }
}
