package FileReading;

import FileReading.Parsers.IParser;

import Modell.Item;

import java.io.*;
import java.util.ArrayList;


public class Loader <T extends  Item>{
    private ArrayList<T> container;
    public Loader() {
        container = new ArrayList<>();
    }
    public ArrayList<T> load(String FileName, IParser parser) throws IOException {

        String line;

        try {

            BufferedReader bfr = new BufferedReader(new FileReader(FileName));

            while ((line = bfr.readLine()) != null) {

                //Solutions would be using type tokens or to generify the parsers
                T objectToAdd = (T) parser.Parse(line);

                if(objectToAdd != null){
                    container.add(objectToAdd);
                }
            }
            bfr.close();

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();

        } catch (IOException e) {
            throw new IOException(e);
        }
        return container;
    }
}
