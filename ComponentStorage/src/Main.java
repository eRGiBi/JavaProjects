import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {

            new Controller().Start();

        } catch (FileNotFoundException e){
            System.out.println("File not found!" + Arrays.toString(e.getStackTrace()));

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}