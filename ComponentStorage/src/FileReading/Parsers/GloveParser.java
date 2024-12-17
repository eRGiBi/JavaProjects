package FileReading.Parsers;

import Modell.Equipments.Glove;
import StorageUnits.CustomerStorage;

import java.util.Objects;


public class GloveParser implements IParser {

    private CustomerStorage customerStorage;
    public GloveParser(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    public Glove Parse(String line) {

        String[] data = line.split(";");

        if(Objects.equals(data[0], "Glove")){
            customerStorage.add(data[4] + ' ' + data[5]);
            return new Glove(Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
        }
        return null;
    }
}
