package com.itheima.pojo;

public class Account {

    private int id;
    private String name;
    private double gz;

    public int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGz() {
        return gz;
    }

    public void setGz(double gz) {
        this.gz = gz;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gz=" + gz +
                '}';
    }
}
