import Reflection.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class main {
    public static void main(String[] args) {
        Person p = new Person();
        int age = 0;    // we dont have getter
        String name = p.getName();
        try {
            //we use getDeclaredFields and not getFields becouse the last one returns all Accesible fields, but age is private
            Field field = p.getClass().getDeclaredField("age");
            field.setAccessible(true);
            field.set(p, (int) 18);
            age = (int)field.get(p);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("We changed the value of private field from main: \nNow the age of the person is: " + age);

        printData(p);

        createNewPerson();
        createNewPersonWithParameters("Marat", 22);
    }

    /**
     * Create new objects in Runtime with reflexion
     */
    private static void createNewPerson() {
        Person p = null;
        try {
            Class clas = Class.forName(Person.class.getName());
            p = (Person) clas.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("The current name of the new Person is = " + p.getName());//output created object reflection.MyClass@60e53b93
    }

    private static void createNewPersonWithParameters(String name, int age) {
        Person p = null;
        try {
            Class clas = Class.forName(Person.class.getName());
            Class[] params = {String.class, int.class};
            p = (Person) clas.getConstructor(params).newInstance(name, age);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("The current name of the new Person is = " + p.getName());//output created object reflection.MyClass@60e53b93
    }

    public static void printData(Object myClass){
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
