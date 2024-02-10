package ua.alikhanov.hw.hw018;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JsonHandler {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonHandler() {
    }

    public static <T> T fromJson(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, clazz);
    }

    public static String toJson(Object object) throws Exception {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> List<T> fromJsonFile(String filePath, Class<T[]> arrayClass) throws Exception {
        return Arrays.asList(objectMapper.readValue(new File(filePath), arrayClass));
    }

    public static void toJsonFile(String filePath, Object object) throws Exception {
        objectMapper.writeValue(new File(filePath), object);
    }

    public static void main(String[] args) {
        try {

            List<Person> persons = fromJsonFile("input.json", Person[].class);


            toJsonFile("output.json", persons);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
