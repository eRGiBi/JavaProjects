package FileReading.Parsers;

import Modell.Products.Pencil;
import StorageUnits.CustomerStorage;

import java.util.Objects;

public class PencilParser implements IParser {
    private CustomerStorage customerStorage;

    public PencilParser(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }
    public Pencil Parse(String line){

        String[] data = line.split(";");

        if(Objects.equals(data[0], "Pencil")){
            customerStorage.add(data[4] + ' ' + data[5]);
            return new Pencil(Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
        }
        return null;
    }
}
