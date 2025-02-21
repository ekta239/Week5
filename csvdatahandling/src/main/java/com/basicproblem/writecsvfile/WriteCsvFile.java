package com.basicproblem.writecsvfile;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCsvFile {
    public static void writeCSV(String filePath) {
            String[] header = {"ID", "Name", "Department", "Salary"};
            String[][] data = {
                    {"1", "Alice", "IT", "60000"},
                    {"2", "Bob", "HR", "50000"},
                    {"3", "Charlie", "Finance", "55000"},
                    {"4", "David", "IT", "65000"},
                    {"5", "Eve", "Marketing", "48000"}
            };

            try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
                writer.writeNext(header);
                for (String[] row : data) {
                    writer.writeNext(row);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





