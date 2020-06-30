package models;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> products;

    public ShoppingCart(){
        products = new HashMap<>();
    }

    public void addItem(Product product){
        if(!products.containsKey(product)){
            products.put(product, 0);
        }
        products.put(product, products.get(product) + 1);
    }

    public void putItems(Product product, int count){
        if(count < 1){
            products.remove(product);
        }
        products.put(product, count);
    }

    public void putItems(String id, int count){
        Product result = getProductById(id);
        if(result != null){
            putItems(result, count);
        }
    }

    public String[] getProductIds(){
        int full = 0;
        String[] result = new String[products.size()];
        for(Product product : products.keySet()){
            result[full++] = product.getId();
        }
        return result;
    }

    public Map<Product, Integer> getProductsAndCounts(){
        return products;
    }

    public double getTotalPrice(){
        double result = 0;
        for (Product product: products.keySet()){
            result += product.getPrice() * products.get(product);
        }
        return result;
    }

    private Product getProductById(String id){
        for (Product product : products.keySet()){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

}
