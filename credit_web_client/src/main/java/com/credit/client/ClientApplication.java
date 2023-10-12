package com.credit.client;

import com.cards.wsdl.Card;
import com.cards.wsdl.GetAllCardsResponse;
import com.cards.wsdl.GetCreditResponse;
import com.credit.client.utils.ServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class ClientApplication {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    SpringApplication.run(ClientApplication.class, args);
  }

  @Bean
  CommandLineRunner lookup(ServiceClient client) {
    return args -> {
      while (true) {
        System.out.println("Enter 1 for person , 2 for lists and 3 for Exit ");
        int opt = sc.nextInt();
        switch (opt) {
          case 1:
            System.out.println("Enter person :");
            String person = sc.next();
            GetCreditResponse response = client.getCredit(person);
            Card c = response.getCustomer();
            System.out.println(c.getTotal());
            System.out.println(c.getBalance());
            System.out.println(c.getCardType());
            break;
          case 2:
            GetAllCardsResponse res = client.getAllCards();
            res.getCollection()
                .forEach(
                    e -> {
                      System.out.println(
                         "Name : " + e.getName()
                              + "\n "+
                           " Total: "   + e.getTotal()
                              + "\n "+
                            " Balance: "  + e.getBalance()
                              + "\n "+
                            " Card Type: "  + e.getCardType());
                    });
            break;
          default:
            System.exit(0);
        }
      }
    };
  }
}
