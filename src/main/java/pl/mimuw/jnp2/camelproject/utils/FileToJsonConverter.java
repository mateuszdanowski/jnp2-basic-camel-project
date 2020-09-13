package pl.mimuw.jnp2.camelproject.utils;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileToJsonConverter {

    private FileToJsonConverter() {

    }

    public static JSONObject convertFileToJson(File file) throws FileNotFoundException {
        String fileName = file.getName();
        String fileBody = readFile(file);
        Date processedAt = new Date();

        Map<String, String> jsonPairs = new HashMap<>();
        jsonPairs.put("filename", fileName);
        jsonPairs.put("content", fileBody);
        jsonPairs.put("processedAt", processedAt.toString());

        return new JSONObject(jsonPairs);
    }

    private static String readFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\Z");
            return scanner.next();
        }
    }
}
