package it.epicode.be.Esercizio2;

import it.epicode.be.Customer;
import it.epicode.be.Order;
import it.epicode.be.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main2 {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        Supplier<Long> randomIdSupplier = () -> {
            Random rndm = new Random();
            return rndm.nextLong(50000, 60000);
        };

        Supplier<Double> randomPrice = () -> {
            Random rndm = new Random();
            return rndm.nextDouble(50, 150);
        };


        Supplier<Product> productSupplier = () -> new Product(randomIdSupplier.get(), "PRODUCT", "Baby", randomPrice.get());


        for (int i = 0; i < 1; i++) {
            products.add(productSupplier.get());

        }
        ;

        Supplier<Long> randomOrderIdSupplier = () -> {
            Random rndm = new Random();
            return rndm.nextLong(0, 500);
        };

        LocalDate today = LocalDate.now();

        Supplier<Integer> deliveryDate = () -> {
            Random rndm = new Random();
            return (rndm.nextInt(2, 5));
        };

        Supplier<Integer> randomTier = () -> {
            Random rndm = new Random();
            return rndm.nextInt(1, 5);
        };
        Supplier<Customer> customerSupplier = () -> new Customer(randomIdSupplier.get(), "CUSTOMERNAME", randomTier.get());


        Supplier<Order> orderSupplier = () -> new Order(randomOrderIdSupplier.get(), "Pending", today, today.plusDays(deliveryDate.get()), products, customerSupplier.get());


        for (int i = 0; i < 10; i++) {
            orders.add(orderSupplier.get());

        }
        ;

        orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).forEach(System.out::println);
    }
}
