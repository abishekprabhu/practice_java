package com.hcl.pojo;

public class Product {
    private int pid;
    private String pName;
    private int cost;

    public Product(){}

    public Product(int pid, String pName, int cost) {
        this.pid = pid;
        this.pName = pName;
        this.cost = cost;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
