import com.homeShop.Cashier;
import com.homeShop.Customer;
import com.homeShop.Shop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("1 Griwa"));
        customers.add(new Customer("2 Olya"));
        customers.add(new Customer("3 Nina"));
        customers.add(new Customer("4 Sveta"));
        customers.add(new Customer("5 Rita"));
        customers.add(new Customer("6 Sasha"));
        customers.add(new Customer("7 Kolya"));
        customers.add(new Customer("8 Vitya"));


        List<Cashier> cashiers = new ArrayList<>();
        cashiers.add(new Cashier("Kassa 1"));
        cashiers.add(new Cashier("Kassa 2"));
        cashiers.add(new Cashier("Kassa 3"));



        List<String> purchases = new ArrayList<>();
        purchases.add("1kolbasa");
        purchases.add("2hleb");
        purchases.add("3moloko");

        new Shop(customers, cashiers, purchases).shopRun();
    }
}
