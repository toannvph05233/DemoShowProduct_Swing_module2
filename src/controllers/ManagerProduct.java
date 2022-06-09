package controllers;

import models.Product;

import java.util.ArrayList;

public class ManagerProduct {
    public ArrayList<Product> products = new ArrayList<>();

    {
        products.add(new Product(1, "oto", 30000));
        products.add(new Product(2, "xemay", 5000));
        products.add(new Product(3, "maybay", 3000000));
    }


}
