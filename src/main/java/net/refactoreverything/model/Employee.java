package net.refactoreverything.model;

public class Employee {
    private int id;
    private int age;
    private String first;
    private String last;

    public Employee(int id, int age, String first, String last) {
        this.id = id;
        this.age = age;
        this.first = first;
        this.last = last;
    }

    public Employee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
