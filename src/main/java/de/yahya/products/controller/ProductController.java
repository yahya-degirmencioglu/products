package de.yahya.products.controller;

import de.yahya.products.dto.ProductDto;
import de.yahya.products.model.Product;
import de.yahya.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Diese Klasse ist ein Spring-Controller, der Endpunkte für Produkte verwaltet.
 *
 * Es bietet verschiedene Endpunkte zum Hinzufügen, Entfernen und Aktualisieren von Produkten im Einkaufswagen,
 * sowie zum Abrufen der Produktliste und des Gesamtpreises.
 *
 * @see ProductDto
 * @see Product
 * @see ProductService
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * Konstruktor für den ProductController, der den ProductService injiziert.
     *
     * @param productService Der ProductService, der zur Verwaltung der Produkte verwendet wird.
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Ein Endpunkt zum Hinzufügen eines Produkts zum Einkaufswagen.
     *
     * @param productDto Das ProductDto-Objekt, das die Informationen des hinzuzufügenden Produkts enthält.
     * @return Die ResponseEntity mit dem hinzugefügten Produkt oder dem entsprechenden Fehlerstatus.
     */
    @PostMapping("/add")
    public ResponseEntity<Product> addToCart(@Valid @RequestBody ProductDto productDto) {
        Product product = productService.addToCart(convertDtoToProduct(productDto));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Ein Endpunkt zum Entfernen eines Produkts aus dem Einkaufswagen.
     *
     * @param productId Die ID des zu entfernenden Produkts.
     * @return Die ResponseEntity mit dem Status OK oder dem entsprechenden Fehlerstatus.
     */
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long productId) {
        productService.removeFromCart(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Ein Endpunkt zum Aktualisieren der Produktmenge im Einkaufswagen.
     *
     * @param productId Die ID des zu aktualisierenden Produkts.
     * @param newQuantity Die neue Menge des Produkts.
     * @return Die ResponseEntity mit dem aktualisierten Produkt oder dem entsprechenden Fehlerstatus.
     */
    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProductQuantity(@PathVariable Long productId, @RequestParam int newQuantity) {
        Product updatedProduct = productService.updateProductQuantity(productId, newQuantity);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    /**
     * Ein Endpunkt zum Abrufen der Liste aller Produkte.
     *
     * @return Die ResponseEntity mit der Liste aller Produkte oder dem entsprechenden Fehlerstatus.
     */
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Ein Endpunkt zum Abrufen eines einzelnen Produkts anhand seiner ID.
     *
     * @param productId Die ID des abzurufenden Produkts.
     * @return Die ResponseEntity mit dem abgerufenen Produkt oder dem Fehlerstatus NOT_FOUND, falls das Produkt nicht gefunden wurde.
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Ein Endpunkt zum Abrufen des Gesamtpreises aller Produkte im Einkaufswagen.
     *
     * @return Die ResponseEntity mit dem Gesamtpreis oder dem entsprechenden Fehlerstatus.
     */
    @GetMapping("/totalPrice")
    public ResponseEntity<Double> getTotalPrice() {
        double totalPrice = productService.getTotalPrice();
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }

    /**
     * Hilfsmethode zum Konvertieren eines ProductDto-Objekts in ein Product-Objekt.
     *
     * @param productDto Das ProductDto-Objekt, das konvertiert werden soll.
     * @return Das konvertierte Product-Objekt.
     */
    private Product convertDtoToProduct(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(Double.parseDouble(productDto.getPrice()))
                .quantity(productDto.getQuantity())
                .build();
    }
}

