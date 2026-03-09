package youssef.nazih.springmvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import youssef.nazih.springmvc.entities.Product;
import youssef.nazih.springmvc.repository.ProductRepository;

@SpringBootApplication
public class SpringmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);
    }


    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.deleteAll();
            productRepository.save(
                    Product.builder()
                            .name("Laptop")
                            .price(5000)
                            .quantity(20)
                            .build()
            );

            productRepository.save(
                    Product.builder()
                            .name("Printer")
                            .price(2000)
                            .quantity(10)
                            .build()
            );

            productRepository.save(
                    Product.builder()
                            .name("Phone")
                            .price(8000)
                            .quantity(15)
                            .build()
            );

            productRepository.findAll().forEach(p->System.out.println(p.toString()));
        };
    }

}
