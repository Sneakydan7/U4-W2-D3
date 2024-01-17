package it.epicode.be.Esercizio3;

import it.epicode.be.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main3 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Supplier<Long> randomIdSupplier = () -> {
            Random rndm = new Random();
            return rndm.nextLong(50000, 60000);
        };

        Supplier<Double> randomPrice = () -> {
            Random rndm = new Random();
            return rndm.nextDouble(50, 150);
        };


        Supplier<Product> productSupplier = () -> new Product(randomIdSupplier.get(), "PRODUCT", "Boys", randomPrice.get());


        for (int i = 0; i < 1; i++) {
            products.add(productSupplier.get());

        }

        products.stream().filter(category -> category.getCategory().equals("Boys")).filter(price -> price.getPrice() > 0).forEach(price -> price.setSconto(price.getPrice()));

    }


}
