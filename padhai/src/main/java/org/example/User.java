package org.example;

import java.util.List;

public class User {

    private int id;

    private String name;

    private List<Integer> phone;

    public User() {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    public User(int id, String name, List<Integer> phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPhone() {
        return phone;
    }

    public void setPhone(List<Integer> phone) {
        this.phone = phone;
    }
}
