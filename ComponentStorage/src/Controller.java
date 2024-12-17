import FileReading.Loader;
import FileReading.Parsers.GloveParser;
import FileReading.Parsers.MaskParser;
import FileReading.Parsers.NotebookParser;
import FileReading.Parsers.PencilParser;
import Modell.Equipments.Glove;
import Modell.Equipments.Mask;
import Modell.Products.Notebook;
import Modell.Products.Pencil;
import StorageUnits.*;

import java.io.IOException;

public class Controller {

    public Controller() {
        Customers = new CustomerStorage();
    }
    //CustomerStorage used with dependency injection
    private CustomerStorage Customers;
    private static final String FileName = "src/Data/Data.csv";

    public void Start() throws IOException {


        GloveStorage gloveStorage = new GloveStorage();
        gloveStorage.addAll(new Loader<Glove>().load(FileName, new GloveParser(Customers)));

        MaskStorage maskStorage = new MaskStorage();
        maskStorage.addAll(new Loader<Mask>().load(FileName, new MaskParser(Customers)));

        NotebookStorage notebookStorage = new NotebookStorage();
        notebookStorage.addAll(new Loader<Notebook>().load(FileName, new NotebookParser(Customers)));

        PencilStorage pencilStorage = new PencilStorage();
        pencilStorage.addAll(new Loader<Pencil>().load(FileName, new PencilParser(Customers)));


        System.out.println("Listing unordered storages:");
        System.out.println();

        gloveStorage.Print();
        System.out.println();
        notebookStorage.Print();
        System.out.println();
        maskStorage.Print();
        System.out.println();
        pencilStorage.Print();
        System.out.println();
        System.out.println("//////////////////////////////////////////");
        System.out.println();

        System.out.println("Listing storages ordered by quantity:");
        System.out.println();
        gloveStorage.SortByQuantity();
        gloveStorage.Print();
        System.out.println();
        notebookStorage.SortByQuantity();
        notebookStorage.Print();
        System.out.println();
        maskStorage.SortByQuantity();
        maskStorage.Print();
        System.out.println();
        pencilStorage.SortByQuantity();
        pencilStorage.Print();
        System.out.println();
        System.out.println("//////////////////////////////////////////");
        System.out.println();

        System.out.println("Listing products ordered by price:");
        System.out.println();
        pencilStorage.SortByPrice();
        pencilStorage.Print();
        System.out.println();
        notebookStorage.SortByPrice();
        notebookStorage.Print();
        System.out.println();
        System.out.println();
        System.out.println("//////////////////////////////////////////");
        System.out.println();

        System.out.println("Listing equipments ordered by security level:");
        System.out.println();
        gloveStorage.SortBySecurityLevel();
        gloveStorage.Print();
        System.out.println();
        maskStorage.SortBySecurityLevel();
        maskStorage.Print();
        System.out.println();
        System.out.println();
        System.out.println("//////////////////////////////////////////");
        System.out.println();

        System.out.println("Listing unordered costumers:");
        System.out.println();
        Customers.Print();
        System.out.println();
        System.out.println("Listing ordered costumers by name:");

        System.out.println();
        Customers.SortByName();
        Customers.Print();
    }
}
