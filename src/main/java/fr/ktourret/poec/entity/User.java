package fr.ktourret.poec.entity;

public class User {

    public String name;

    public int age;

    public String nationality = "Française";

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
