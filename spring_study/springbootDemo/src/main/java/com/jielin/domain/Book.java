package com.jielin.domain;

public class Book {
    private String name;
    private String owner;
    private int id;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
