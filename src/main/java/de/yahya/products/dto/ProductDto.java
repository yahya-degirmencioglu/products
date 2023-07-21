package de.yahya.products.dto;

import de.yahya.products.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Diese Klasse repräsentiert ein Datenübertragungsobjekt (DTO) für ein Produkt.
 *
 * Ein DTO ist ein einfaches POJO (Plain Old Java Object), das dazu dient,
 * Daten zwischen verschiedenen Schichten oder Komponenten einer Anwendung zu übertragen.
 *
 * @see Product
 */
@Data
@AllArgsConstructor
public class ProductDto {
    /**
     * Die eindeutige ID des Produkts.
     */
    private long id;

    /**
     * Der Name des Produkts.
     */
    private String name;

    /**
     * Die Beschreibung des Produkts.
     */
    private String description;

    /**
     * Der Preis des Produkts als Zeichenfolge (im Format "xx,yy").
     * Beachten Sie, dass das Komma durch einen Punkt ersetzt werden muss,
     * um eine gültige Gleitkommazahl zu erhalten.
     */
    private String price;

    /**
     * Die Anzahl des Produkts.
     */
    private int quantity;

    /**
     * Konvertiert das ProductDto-Objekt in ein Product-Objekt.
     *
     * @return Das konvertierte Product-Objekt.
     */
    public Product convert() {
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setDescription(description);
        p.setPrice(Double.parseDouble(price.replace(",", ".")));
        p.setQuantity(quantity);
        return p;
    }
}
