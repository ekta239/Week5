package com.advanceproblems.generatecsvfromdatabase;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.sql.*;

public class GenerateCsv {
    public static void exportToCSV(String filePath, Connection conn) {
        String query = "SELECT id, name, department, salary FROM employees";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});
            while (rs.next()) {
                writer.writeNext(new String[]{
                        String.valueOf(rs.getInt("id")),
                        rs.getString("name"),
                        rs.getString("department"),
                        String.valueOf(rs.getDouble("salary"))
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

