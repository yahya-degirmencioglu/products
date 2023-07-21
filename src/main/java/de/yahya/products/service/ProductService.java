package de.yahya.products.service;

        import de.yahya.products.model.Product;
        import de.yahya.products.repository.ProductRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

/**
 * Diese Klasse implementiert den Geschäftslogik-Service für Produkte.
 *
 * Der Service bietet verschiedene Funktionen zum Hinzufügen, Entfernen und Aktualisieren von Produkten im Warenkorb.
 * Außerdem können Gesamtpreisberechnungen und Abfragen aller Produkte durchgeführt werden.
 *
 * @see ProductRepository
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Konstruktor für den ProductService.
     *
     * @param productRepository Das Repository für den Zugriff auf Produkt-Daten.
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Fügt ein Produkt zum Warenkorb hinzu oder aktualisiert es, falls es bereits vorhanden ist.
     *
     * @param product Das hinzuzufügende Produkt.
     * @return Das hinzugefügte oder aktualisierte Produkt.
     */
    public Product addToCart(Product product) {
        return productRepository.save(product);
    }

    /**
     * Entfernt ein Produkt aus dem Warenkorb anhand seiner ID.
     *
     * @param productId Die ID des zu entfernenden Produkts.
     */
    public void removeFromCart(long productId) {
        productRepository.deleteById(productId);
    }

    /**
     * Aktualisiert die Menge eines Produkts im Warenkorb.
     *
     * @param productId Die ID des zu aktualisierenden Produkts.
     * @param newQuantity Die neue Menge des Produkts.
     * @return Das aktualisierte Produkt oder null, wenn das Produkt nicht gefunden wurde.
     */
    public Product updateProductQuantity(Long productId, int newQuantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            product.setQuantity(newQuantity);
            return productRepository.save(product);
        }
        return null;
    }

    /**
     * Speichert ein Produkt.
     *
     * @param product Das zu speichernde Produkt.
     * @return Das gespeicherte Produkt.
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Berechnet den Gesamtpreis aller Produkte im Warenkorb.
     *
     * @return Der Gesamtpreis aller Produkte.
     */
    public double getTotalPrice() {
        double summe = 0;
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            summe = summe + product.getQuantity() * product.getPrice();
        }
        return summe;
    }

    /**
     * Ruft eine Liste aller Produkte ab.
     *
     * @return Eine Liste aller Produkte.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Ruft ein Produkt anhand seiner ID ab.
     *
     * @param id Die ID des abzurufenden Produkts.
     * @return Das gefundene Produkt oder null, wenn kein Produkt mit der ID gefunden wurde.
     */
    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Sucht ein Produkt anhand seiner ID.
     *
     * @param id Die ID des zu suchenden Produkts.
     * @return Ein Optional, das das gefundene Produkt enthält oder leeres Optional, wenn kein Produkt mit der ID gefunden wurde.
     */
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

}
