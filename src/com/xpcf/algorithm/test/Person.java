package com.xpcf.algorithm.test;

import java.util.Objects;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/26/2021 11:58 AM
 */
public class Person {

    private Integer age;

    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        // 31 * i -> (2^5 - 1) * i -> i * 2^5 - i -> i << 5 - i
        int result = age != null ? age.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Student student = new Student();
        Person person = new Person();
        System.out.println(student instanceof Person);
    }
    static class Student extends Person {

    }
}
