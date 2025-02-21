package com.basicproblem.countrowsincsv;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
public class CountRows {
    public static int countRows(String filePath) {
        int count = -1; // Exclude header row
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            while (reader.readNext() != null) {
                count++;
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return count;
    }
}




