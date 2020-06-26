package cn.yy.test2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class SetTest {

    @Test
    public void testSet(){
        Person p1=new Person(1,"AA");
        Person p2=new Person(2,"BB");


        Person[] people={p1,p2};
        System.out.println(Arrays.toString(people));

        p1.setName("CC");
        System.out.println(Arrays.toString(people));

//        HashSet<Person> set=new HashSet<>();
//        set.add(p1);
//        set.add(p2);
//        System.out.println(set);
//        p1.setName("CC");
//        System.out.println(set);
    }
}


class Person{
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
