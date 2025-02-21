package com.advanceproblems.convertjsontocsv;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class ConvertJsontoCsv {
    public static void convertJsonToCsv(String jsonFile, String csvFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, String>> data = objectMapper.readValue(new File(jsonFile),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class));

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                if (!data.isEmpty()) {
                    writer.writeNext(data.get(0).keySet().toArray(new String[0]));
                    for (Map<String, String> row : data) {
                        writer.writeNext(row.values().toArray(new String[0]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
