package StorageUnits;

import Modell.Products.Notebook;

import java.util.ArrayList;

public class NotebookStorage extends ProductStorage{

    private ArrayList<Notebook> Container;

    public NotebookStorage() {
        Container = new ArrayList<Notebook>();
    }
    public void add(Notebook notebook){
        Container.add(notebook);
    }
    public void addAll(ArrayList<Notebook> list){
        Container.addAll(list);
    }
    @Override
    public void SortByQuantity() {
        for (int i = 0; i < Container.size() - 1; i++) {
            for (int j = i + 1; j < Container.size(); j++) {
                Notebook temp = Container.get(i);
                Notebook temp2 = Container.get(j);
                if (temp.getQuantity() > temp2.getQuantity()) {
                    Container.set(i, temp2);
                    Container.set(j, temp);
                }
            }
        }
    }
    @Override
    public void SortByPrice() {
        for (int i = 0; i < Container.size() - 1; i++) {
            for (int j = i + 1; j < Container.size(); j++) {
                Notebook temp = Container.get(i);
                Notebook temp2 = Container.get(j);
                if (temp.getPrice() > temp2.getPrice()) {
                    Container.set(i, temp2);
                    Container.set(j, temp);
                }
            }
        }
    }
    @Override
    public void Print() {
        for (Notebook notebook: Container) {
            System.out.println(notebook);
        }
    }
}
