import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import reflection.ObjectToJsonConverter;
import reflection.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class main {
    public static void main(String[] args) {
        /*Person person = new Person("Marat",34);
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        try {
            String jsonString = serializer.convertToJson(person);
            System.out.println(jsonString);
        } catch (ObjectToJsonConverter.JsonSerializableException e) {
            e.printStackTrace();
        }*/

        Result result = JUnitCore.runClasses(JsonConverterTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Is the result correct: " + result.wasSuccessful());



    }
}
