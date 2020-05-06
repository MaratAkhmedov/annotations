package Reflection;

/**
 * Sometimes we can use libraries with some private object properties
 * which dont have getters/setters for those properties, in some cases
 * it is made intentionally but sometimes, the person who made that library
 * had made an error.
 * If we have source code we can easily made changes that we need but sometimes,
 * we cant do it, in those cases it is very usefull Reflection in Java
 * In this example, Person is a normal class what dont have getters/setters for age,
 * we will use reflection to set up this property
 */
public class Person {
    private String name = "Default";
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Lets suggest that this method is private by error
     * and we should use this method but we cant becouse it is private
     */
    private void printData() {
        System.out.println("Name: " + this.name + " Age: " +this.age);
    }

}
