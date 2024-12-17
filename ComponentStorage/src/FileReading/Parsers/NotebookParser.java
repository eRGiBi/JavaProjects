package FileReading.Parsers;

import Modell.Products.Notebook;
import StorageUnits.CustomerStorage;

import java.util.Objects;


public class NotebookParser implements IParser {
    private CustomerStorage customerStorage;
    public NotebookParser(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    public Notebook Parse(String line){

        String[] data = line.split(";");

        if(Objects.equals(data[0], "Notebook")){
            customerStorage.add(data[4] + ' ' + data[5]);
            return new Notebook(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
        }
        return null;
    }
}
