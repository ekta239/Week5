package com.advanceproblems.mergetwocsv;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MergeTwoCsvFile {
    public static void mergeCSV(String file1, String file2, String outputFile) {
        Map<String, String[]> studentData = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1));
             CSVReader reader2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String[] line;
            while ((line = reader1.readNext()) != null) {
                studentData.put(line[0], line);
            }

            while ((line = reader2.readNext()) != null) {
                if (studentData.containsKey(line[0])) {
                    String[] details = studentData.get(line[0]);
                    writer.writeNext(new String[]{details[0], details[1], details[2], line[1], line[2]});
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
