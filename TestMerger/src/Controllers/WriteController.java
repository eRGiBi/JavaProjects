package Controllers;

import Model.Scholar;
import Model.ScholarContainer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteController {

    public void writeFile(ScholarContainer scholars) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("TestMerger/data/assessment.txt"));

        bufferedWriter.write(String.valueOf(scholars));

        bufferedWriter.close();
    }
}
