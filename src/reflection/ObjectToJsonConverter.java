package reflection;

import annotations.Init;
import annotations.JsonElement;
import annotations.JsonSerializable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

    public String convertToJson(Object object) throws JsonSerializableException {
        try {
            checkSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        } catch (Exception e) {
            throw new JsonSerializableException(e.getMessage());
        }
    }

    private void checkSerializable(Object object) throws JsonSerializableException {
        if (Objects.isNull(object)) {
            throw new JsonSerializableException("The object that you want serialize is null");
        }

        Class<?> clas = object.getClass();
        if (!clas.isAnnotationPresent(JsonSerializable.class)) {
            throw new JsonSerializableException("The class "
                    + clas.getSimpleName()
                    + " is not annotated with JsonSerializable");
        }
    }


    private void initializeObject(Object object) throws Exception {
        Class<?> clas = object.getClass();
        for (Method method : clas.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws Exception {
        Class<?> clas = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clas.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(field.getName(), field.get(object).toString());
            }
        }

        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }


    /**
     * My custom Exception class
     */
    public class JsonSerializableException extends Exception {
        public JsonSerializableException(String s) {
            super(s);
        }
    }
}
