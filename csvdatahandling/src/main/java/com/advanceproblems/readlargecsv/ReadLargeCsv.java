package com.advanceproblems.readlargecsv;

import java.io.*;
public class ReadLargeCsv {
    public static void readLargeCSV(String filePath) {
        int batchSize = 100;
        int recordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                recordCount++;
                if (recordCount % batchSize == 0) {
                    System.out.println("Processed " + recordCount + " records...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total Records Processed: " + recordCount);
    }
}


