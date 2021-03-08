import com.homeShop.Cashier;
import com.homeShop.Customer;
import com.homeShop.Shop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Griwa"));
        customers.add(new Customer("Olya"));
        customers.add(new Customer("Nina"));
        customers.add(new Customer("Sveta"));
        customers.add(new Customer("Rita"));
        customers.add(new Customer("Sasha"));
        customers.add(new Customer("Kolya"));
        customers.add(new Customer("Vitya"));


        List<Cashier> cashiers = new ArrayList<>();
        cashiers.add(new Cashier("Kassa1"));
        cashiers.add(new Cashier("Kassa2"));
        cashiers.add(new Cashier("Kassa3"));



        List<String> purchases = new ArrayList<>();
        purchases.add("kolbasa");
        purchases.add("hleb");
        purchases.add("moloko");

        new Shop(customers, cashiers, purchases).shopRun();
    }
}
