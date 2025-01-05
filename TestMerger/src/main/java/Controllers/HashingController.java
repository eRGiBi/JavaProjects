package Controllers;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class HashingController {

    public void hash(String inputDirectory, String outputDirectory) throws IOException, NoSuchAlgorithmException {

        Files.createDirectories(Paths.get(outputDirectory));

        Files.list(Paths.get(inputDirectory))
                .filter(path -> path.toString().endsWith(".csv"))
                .forEach(path -> {
                    try {
                        processCSV(path.toString(), outputDirectory + "/" + path.getFileName());
                    } catch (Exception e) {
                        System.err.println("Error processing file: " + path + " - " + e.getMessage());
                    }
                });

        System.out.println("All files processed and saved to " + outputDirectory);
    }

    public static void processCSVWithopencsv(String inputFilePath, String outputFilePath) throws IOException,
            NoSuchAlgorithmException, CsvException {

        try (
                CSVReader reader = new CSVReader(new FileReader(inputFilePath));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))
        ) {
            List<String[]> rows = reader.readAll();

            for (String[] row : rows) {
                row[0] = generateHash(row[0]);
                writer.writeNext(row);
            }
        }
    }

    public static void processCSV(String inputFilePath, String outputFilePath) throws IOException,
            NoSuchAlgorithmException {

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");

                columns[0] = generateHash(columns[0]);

                writer.write(String.join(";", columns));
                writer.newLine();
            }
        }
    }

    public static String generateHash(String value) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(value.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

}
