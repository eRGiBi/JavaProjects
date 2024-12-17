package FileReading.Parsers;

import Modell.Equipments.Mask;
import StorageUnits.CustomerStorage;

import java.util.Objects;

public class MaskParser implements IParser{

    CustomerStorage customerStorage;
    public MaskParser(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    public Mask Parse(String line) {

        String[] data = line.split(";");


        if (Objects.equals(data[0], "Mask")) {
            customerStorage.add(data[4] + ' ' + data[5]);
            return new Mask(Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
        }
        return null;
    }

}

