package practice11;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private int id;

    public Person(int id,String name,int age){
        this.name=name;
        this.age=age;
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String introduce(){
        return "My name is "+name+". I am "+age+" years old.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

