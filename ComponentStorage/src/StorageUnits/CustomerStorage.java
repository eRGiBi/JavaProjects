package StorageUnits;

import java.util.ArrayList;

public class CustomerStorage {

    private ArrayList<String> Customers;

    public CustomerStorage() {
        Customers = new ArrayList<>();
    }

    public void add(String customer){
        Customers.add(customer);
    }

    public void Print() {
        for (String customer : Customers) {
            System.out.println(customer);
        }
    }
    public void SortByName(){
        for (int i = 0; i < Customers.size() - 1; i++) {
            for (int j = i + 1; j < Customers.size(); j++) {
                String temp = Customers.get(i);
                String temp2 = Customers.get(j);

                int k = 0;
                if(temp.charAt(k) > temp2.charAt(k)) {
                    Customers.set(i, temp2);
                    Customers.set(j, temp);

                } else if (temp.charAt(k) == temp2.charAt(k)) {

                    while (k < temp.length() && k < temp2.length()) {
                        if (temp.charAt(k) > temp2.charAt(k)) {
                            Customers.set(i, temp2);
                            Customers.set(j, temp);
                            break;
                        }
                        if (temp.charAt(k) < temp2.charAt(k)) {
                            break;
                        }
                        k++;
                    }
                }
            }
        }
    }
}
