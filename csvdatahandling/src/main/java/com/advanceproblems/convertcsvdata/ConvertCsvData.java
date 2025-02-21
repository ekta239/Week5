package com.advanceproblems.convertcsvdata;
import com.advanceproblems.validatecsvdata.Student;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ConvertCsvData {
    public static List<Student> convertToObjects(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
