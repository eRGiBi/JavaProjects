package StorageUnits;

import Modell.Equipments.Glove;

import java.util.ArrayList;

public class GloveStorage extends EquipmentStorage
{
    private ArrayList<Glove> Container;

    public GloveStorage() {
        Container =  new ArrayList<Glove>();
    }
    public void add(Glove glove) {
        Container.add(glove);
    }

    public void addAll(ArrayList<Glove> list){
        Container.addAll(list);
    }

    @Override
    public void SortByQuantity() {
        for (int i = 0; i < Container.size() - 1; i++) {
            for (int j = i + 1; j < Container.size(); j++) {
                Glove temp = Container.get(i);
                Glove temp2 = Container.get(j);
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
                Glove temp = Container.get(i);
                Glove temp2 = Container.get(j);
                if (temp.getSecurityLevel() > temp2.getSecurityLevel()) {
                    Container.set(i, temp2);
                    Container.set(j, temp);
                }
            }
        }
    }

    @Override
    public void Print() {
        for (Glove glove: Container) {
            System.out.println(glove);
        }
    }


}
