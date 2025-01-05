package Loading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class Loader {

    public Loader () {
         }

    public HashMap<String, Double> readFile(String filename) throws FileNotFoundException {

        HashMap<String, Double> examData = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line;
        String[] splitLine;

        try {
            while ((line = br.readLine()) != null) {

                // Without a Parser

                splitLine = line.split(";");
                splitLine[1] = splitLine[1].replace(",", ".");

                double result = Double.parseDouble(splitLine[1]);

                examData.put(splitLine[0], result);

            } br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return examData;
    }
}