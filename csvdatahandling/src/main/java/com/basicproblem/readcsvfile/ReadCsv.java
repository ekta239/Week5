package com.basicproblem.readcsvfile;


import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsv {
    public static void readCsv(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            try {
                while ((nextLine = reader.readNext()) != null) {
                    System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1] +
                            ", Age: " + nextLine[2] + ", Marks: " + nextLine[3]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

