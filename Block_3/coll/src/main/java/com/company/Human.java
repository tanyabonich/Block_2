package com.company;

/**
 * Created by Таня on 17.05.2017.
 */
public class Human {
    private String name;
    private String secondName;
    private String fathersName;
    private int age;


    public Human(String name, String secondName, String fathersName, int age) {
        this.name = name;
        this.secondName = secondName;
        this.fathersName = fathersName;
        this.age = age;
    }



    public Human(Human h) {
        this.name = h.getName();
        this.secondName = h.getSecondName();
        this.fathersName = h.getFathersName();
        this.age = h.getAge();
    }



    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;

        Human human = (Human) o;

        if (getAge() != human.getAge()) return false;
        if (!getName().equals(human.getName())) return false;
        if (!getSecondName().equals(human.getSecondName())) return false;
        return getFathersName().equals(human.getFathersName());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSecondName().hashCode();
        result = 31 * result + getFathersName().hashCode();
        result = 31 * result + getAge();
        return result;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", age=" + age +
                '}';
    }
}
