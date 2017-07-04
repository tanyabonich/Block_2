package com.company;

/**
 * Created by Таня on 04.07.2017.
 */
public class Student extends Human {
    private String department;


    public Student(Student s) {
        super(s);
        department = s.getDepartment();
    }

    public Student(String name, String secondName, String fathersName, int age, String department) {
        super(name, secondName, fathersName, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", secondName='" + getSecondName() + '\'' +
                ", fathersName='" + getFathersName() + '\'' +
                ", age=" + getAge() +
                ", department='" + department + '\'' + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (!getDepartment().equals(student.getDepartment())) return false;
        if (getAge() != student.getAge()) return false;
        if (!getName().equals(student.getName())) return false;
        if (!getSecondName().equals(student.getSecondName())) return false;
        return getFathersName().equals(student.getFathersName());

    }
}
