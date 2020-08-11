package class04forExit;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 自定义排序规则
 *
 * */
public class Code01_Comparator {

    public static class Person{
        private int age;
        private String name;
        private int id;
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public Person(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    public static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.age-o2.age;
        }
    }

    public static void main(String[] args) {
        Person person1=new Person(1,"hi",2);
        Person person2=new Person(9,"lili",2);
        Person person3=new Person(6,"av",2);
        Person[] persons={person1,person2,person3};
        Arrays.sort(persons,new PersonComparator());
        for (Person person : persons) {
            System.out.println(person.toString());
        }

    }
}
