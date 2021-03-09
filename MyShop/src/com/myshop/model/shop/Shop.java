package com.myshop.model.shop;

import com.myshop.exceptions.data.fabric.FabricWrongInitDataException;
import com.myshop.exceptions.shop.ShopProductAlreadyExistsException;
import com.myshop.exceptions.shop.ShopProductDoesntExistsException;
import com.myshop.fabric.FabricVariants;
import com.myshop.fabric.Fabrics;
import com.myshop.model.product.Product;
import com.myshop.model.warehouse.Warehouse;

import java.util.*;


public class Shop {
    private final LinkedHashSet<Product> products = new LinkedHashSet<>();
    private final List<String> purchasesLog = new LinkedList<>();
    private Warehouse warehouse = null;

    public Shop() {
        try {
            warehouse = Fabrics.getRequiredFabric(Warehouse.class).getSomeObject(FabricVariants.WAREHOUSE.toString());
        } catch (FabricWrongInitDataException fabricWrongInitDataException) {
            System.err.println("Warehouse creation failed");
        }
    }

    public void addProductInShop(Product product) throws ShopProductAlreadyExistsException {
        if (productExist(product)) {
            throw new ShopProductAlreadyExistsException(String.format("Unable to add product: %s", product));
        }
        products.add(product);
    }

    public List<Product> getAllProductsInShop() {
        return new ArrayList<>(products);
    }

    public void deleteProductInShop(Product product) throws ShopProductDoesntExistsException {
        if (!productExist(product)) {
            throw new ShopProductDoesntExistsException(String.format("Unable to delete product: %s", product));
        }
        products.remove(product);
    }

    public void editProductInShop(Product product) throws ShopProductDoesntExistsException {
        if (!productExist(product)) {
            throw new ShopProductDoesntExistsException(String.format("Unable to edit product: %s", product));
        }
        products.remove(product);
        products.add(product);
    }

    public Product getProduct(int id) throws ShopProductDoesntExistsException {
        Product product = getProductById(id);
        if (product == null) {
            throw new ShopProductDoesntExistsException("Unable to get product");
        }
        return product;
    }

    private Product getProductById(int id) {
        for (Product product : products) {
            if (product.getID() == id) return product;
        }
        return null;
    }

    public void addProductInWarehouse(Product product, int count) {
        warehouse.storeProduct(product, count);
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


    public Set<String> getProductsTypeInShop() {
        Set<String> tmp = new HashSet<>();
        for (Product product : products) {
            tmp.add(product.getType());
        }
        return tmp;
    }

    public boolean productExist(int id) {
        return getProductById(id) != null;
    }

    public boolean productExist(Product product) {
        return productExist(product.getID());
    }

}
