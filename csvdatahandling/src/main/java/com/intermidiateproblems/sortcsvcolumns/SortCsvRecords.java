package com.intermidiateproblems.sortcsvcolumns;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class SortCsvRecords {
    public static void sortRecords(String filePath) {
        List<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            records = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));
        records.stream().limit(5).forEach(row -> System.out.println(String.join(", ", row)));
    }
}

