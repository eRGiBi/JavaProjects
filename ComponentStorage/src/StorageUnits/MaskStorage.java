package StorageUnits;

import Modell.Equipments.Mask;
import java.util.ArrayList;

public class MaskStorage extends EquipmentStorage {

    private ArrayList<Mask> Container;
    public MaskStorage() {

        Container = new ArrayList<Mask>();
    }
    public void add(Mask mask) {
        Container.add(mask);
    }

    public void addAll(ArrayList<Mask> list){
        Container.addAll(list);
    }

    @Override
    public void SortByQuantity() {
        for (int i = 0; i < Container.size() - 1; i++) {
            for (int j = i + 1; j < Container.size(); j++) {
                Mask temp = Container.get(i);
                Mask temp2 = Container.get(j);
                if (temp.getQuantity() > temp2.getQuantity()) {
                    Container.set(i, temp2);
                    Container.set(j, temp);
                }
            }
        }
    }
    @Override
    public void SortBySecurityLevel() {
        for (int i = 0; i < Container.size() - 1; i++) {
            for (int j = i + 1; j < Container.size(); j++) {
                Mask temp = Container.get(i);
                Mask temp2 = Container.get(j);
                if (temp.getSecurityLevel() > temp2.getSecurityLevel()) {
                    Container.set(i, temp2);
                    Container.set(j, temp);
                }
            }
        }
    }
    @Override
    public void Print() {
        for (Mask mask: Container) {
            System.out.println(mask);
        }
    }
}