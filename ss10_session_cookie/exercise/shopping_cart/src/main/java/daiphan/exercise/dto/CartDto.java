package daiphan.exercise.dto;

import daiphan.exercise.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> products = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(ProductDto product) {
        return products.containsKey(product);
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto product) {
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product)) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(ProductDto product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {

            Integer newQuantity = products.get(product) + 1;
            products.replace(product, newQuantity);
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public double countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (double) entry.getValue();
        }
        return payment;
    }

    public void reduceProduct(ProductDto product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1) {
                Integer newQuantity = products.get(product) - 1;
                products.replace(product, newQuantity);
            } else {
                products.remove(product);
            }
        }
    }
}
