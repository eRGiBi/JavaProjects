import Controllers.MainController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {

        int seed = 476;

        try {
            new MainController(seed).start();

        } catch (FileNotFoundException e) {
            System.err.println("Error: The file could not be found. Please check the file path.");
            e.printStackTrace();

        } catch (IOException e) {
            System.err.println("Error: An input-output error occurred.");
            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: The specified algorithm could not be found.");
            e.printStackTrace();

        } catch (IllegalArgumentException e) {
            System.err.println("Error: An invalid argument was provided.");
            e.printStackTrace();

        } catch (IllegalStateException e) {
            System.err.println("Error: The application is in an illegal state.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
