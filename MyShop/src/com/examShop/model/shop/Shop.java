package com.examShop.model.shop;

import com.examShop.exceptions.Shop.ShopNullProductException;
import com.examShop.fabric.FabricCase;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.warehouse.Warehouse;

import java.util.*;


public class Shop {
    private final LinkedHashMap<Integer, Product> products = new LinkedHashMap<>();
    private final Warehouse warehouse = FabricControl.getRequiredFabric(Warehouse.class).getSomeObject(FabricCase.WAREHOUSE.toString());
    private final List<String> purchasesLog = new LinkedList<>();

    public boolean addProductInShop(Product product) {
        if (products.containsKey(product.getID())) {
            return false;
        }
        products.put(product.getID(), product);
        return true;
    }

    public List<Product> getAllProductsInShop() {
        return new ArrayList<>(products.values());
    }

    public boolean deleteProductInShop(int id) {
        products.remove(id);
        return checkProduct(id);
    }

    public boolean editProductInShop(Product product) {
        boolean flag = checkProduct(product.getID());
        if (flag) {
            products.put(product.getID(), product);
        }
        return flag;
    }

    public Product getProduct(int id) {
        if (!checkProduct(id)) {
            throw new ShopNullProductException(id);
        }
        return products.get(id);
    }

    public void addProductInWarehouse(Product product, int count) {
        warehouse.addProduct(product, count);
    }

    public void removeProductFromWarehouse(Product product) {
        warehouse.removeProduct(product);
    }

    public boolean buyProductFromWarehouse(Product product, int count) {
        String tmp = product.toString() + " Quantity:" + count + " Money:" + count * product.getPrice();
        if (warehouse.editProductCount(product, -count)) {
            purchasesLog.add(tmp);
            return true;
        } else {
            return false;
        }
    }

    public int getCountInWarehouse(Product product) {
        return warehouse.getCount(product);
    }

    public int getCountProductsInShop() {
        return products.size();
    }

    public int getCountProductsTypeInShop() {
        Set<String> tmp = new HashSet<>();
        for (Product product : products.values()) {
            tmp.add(product.getType());
        }
        return tmp.size();
    }

    public int getAveragedCostProducts() {
        int tmp = 0;
        for (Product product : products.values()) {
            tmp += product.getPrice();
        }
        return tmp / products.size();
    }


    private boolean checkProduct(int id) {
        return products.containsKey(id);
    }
}
