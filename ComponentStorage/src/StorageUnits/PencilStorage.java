package StorageUnits;

import Modell.Products.Pencil;

import java.util.ArrayList;

public class PencilStorage extends ProductStorage{

    private ArrayList<Pencil> Container;
    public PencilStorage() {
        Container = new ArrayList<Pencil>();
    }
    public void add(Pencil pencil){
        Container.add(pencil);
    }
    public void addAll(ArrayList<Pencil> list) {
        Container.addAll(list);
    }

    @Override
    public void SortByQuantity() {
        for (int i = 0; i < Container.size() - 1; i++) {
            for (int j = i + 1; j < Container.size(); j++) {
                Pencil temp = Container.get(i);
                Pencil temp2 = Container.get(j);
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
                Pencil temp = Container.get(i);
                Pencil temp2 = Container.get(j);
                if (temp.getPrice() > temp2.getPrice()) {
                    Container.set(i, temp2);
                    Container.set(j, temp);
                }
            }
        }
    }

    @Override
    public void Print() {
        for (Pencil pencil: Container) {
            System.out.println(pencil);
        }
    }
}
