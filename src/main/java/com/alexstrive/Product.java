package com.alexstrive;

public class Product extends Composite {
    public Product(String name) {
        super(name);
    }

    public boolean addProduct(Product product) {
        return add(product);
    }
}
