package it.epicode.be.Esercizio1;

import it.epicode.be.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main1 {
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


        Supplier<Product> productSupplier = () -> new Product(randomIdSupplier.get(), "PRODUCT", "Books", randomPrice.get());


        for (int i = 0; i < 20; i++) {
            products.add(productSupplier.get());

        }
        products.stream().filter(category -> category.getCategory().equals("Books")).filter(price -> price.getPrice() > 100).forEach(System.out::println);

    }


}
