package de.yahya.products;

import de.yahya.products.model.Product;
import de.yahya.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class ProductApplication implements WebMvcConfigurer, CommandLineRunner {

    /**
     * Die Hauptmethode der Anwendung.
     *
     * @param args Die Befehlszeilenargumente.
     */
    public static void main(String[] args) {SpringApplication.run(ProductApplication.class, args);}

    @Autowired
    private ProductRepository productRepository;

    @Value("${db.reset}") // greift auf den Wert aus application.yaml zu
    private boolean dbReset;

    /**
     * Methode, die automatisch ausgeführt wird, wenn die Anwendung gestartet wird.
     *
     * @param args Die Befehlszeilenargumente.
     * @throws Exception Wenn ein Fehler auftritt.
     */
    @Override
    public void run(String... args) throws Exception {

    }

}
