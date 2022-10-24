package com.company;

public class Person {
    private String ten;
    private int tuoi;

    public Person(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }
}
