package com.intermidiateproblems.modifycsvfile;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

public class ModifyCsvFile {
    public static void updateSalary(String inputFile, String outputFile) {
        List<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(nextLine[3]) * 1.1;
                    nextLine[3] = String.valueOf(salary);
                }
                records.add(nextLine);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeAll(records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

