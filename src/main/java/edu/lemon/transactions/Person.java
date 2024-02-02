package edu.lemon.transactions;

import java.util.Objects;
import java.util.UUID;

class Person {
    private final UUID id;
    private final String name;
    private final int age;
    private final String email;

    Person(UUID id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Person) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                this.age == that.age &&
                Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }

    @Override
    public String toString() {
        return "Person[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "age=" + age + ", " +
                "email=" + email + ']';
    }
}
