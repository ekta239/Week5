package com.advanceproblems.detectduplicatecsv;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicate {
        public static void findDuplicates(String filePath) {
            Map<String, Integer> idCount = new HashMap<>();

            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    idCount.put(nextLine[0], idCount.getOrDefault(nextLine[0], 0) + 1);
                }
            } catch (IOException | CsvValidationException e) {
                e.printStackTrace();
            }

            idCount.forEach((id, count) -> {
                if (count > 1) {
                    System.out.println("Duplicate ID: " + id + " appears " + count + " times.");
                }
            });
        }
    }




