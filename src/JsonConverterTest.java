import org.junit.After;
import org.junit.Test;
import reflection.ObjectToJsonConverter;
import reflection.Person;

import static junit.framework.TestCase.assertEquals;

public class JsonConverterTest {
    @Test
    public void givenObjectSerializedThenTrueReturned() {
        Person person = new Person("Marat", 34);
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = null;
        try {
            jsonString = serializer.convertToJson(person);
            assertEquals(
                    "{\"name\":\"Marat\",\"age\":\"34\"}",
                    jsonString);
        } catch (ObjectToJsonConverter.JsonSerializableException e) {
            e.printStackTrace();
        }
    }
}
