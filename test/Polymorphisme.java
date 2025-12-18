
import java.util.ArrayList;

// package test;
public class Polymorphisme {

    public static void main(String[] args) {
        // Animal myAnimal;

        // myAnimal = new Dog();
        // myAnimal.speak(); // Output: Dog barks
        // myAnimal = new Cat();
        // myAnimal.speak(); // Output: Cat meows
        ArrayList<Person> originalList = new ArrayList<>();
        originalList.add(new Person("Alice"));
        originalList.add(new Person("Bob"));
        ArrayList<Person> shallowCopyList = (ArrayList<Person>) originalList.clone();
        System.out.print("Results of shallow copy : ");
        System.out.println(originalList == shallowCopyList); // false
        shallowCopyList.get(0).name = "Charlie";
        System.out.println("Original List after modifying shallow copy:");
        System.out.println(originalList); // [Charlie, Bob]
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }

    // Deep copy
    @Override
    protected Person clone() {
        return new Person(this.name);
    }

    @Override
    public String toString() {
        return name;
    }

}

class Animal {

    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {

    // @Override
    void speak() {
        System.out.println("hh");
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    // @Override
    void speak() {
        System.out.println("Cat meows");
    }
}
