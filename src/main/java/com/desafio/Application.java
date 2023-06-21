package com.desafio;

import com.desafio.entities.Order;
import com.desafio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args)  {
       SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner enter = new Scanner(System.in);

        int code = enter.nextInt();
        double basic = enter.nextDouble();
        double discount = enter.nextDouble();

        Order order = new Order(code, basic, discount);

        System.out.println("Pedido codigo: " + code);
        System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));

        enter.close();
    }
}