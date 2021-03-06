import com.homeShop.Cashier;
import com.homeShop.Costumer;
import com.homeShop.Shop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Costumer> costumers = new ArrayList<>();
        costumers.add(new Costumer("Griwa"));
        costumers.add(new Costumer("Olya"));
        costumers.add(new Costumer("Nina"));
        costumers.add(new Costumer("Sveta"));
        costumers.add(new Costumer("Rita"));
        costumers.add(new Costumer("Sasha"));
        costumers.add(new Costumer("Kolya"));
        costumers.add(new Costumer("Vitya"));


        List<Cashier> cashiers = new ArrayList<>();
        cashiers.add(new Cashier("Kassa1"));
        cashiers.add(new Cashier("Kassa2"));
        cashiers.add(new Cashier("Kassa3"));



        List<String> purchases = new ArrayList<>();
        purchases.add("kolbasa");
        purchases.add("hleb");
        purchases.add("moloko");

        new Shop(costumers, cashiers, purchases).shopRun();
    }
}
