package de.yahya.products.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Diese Klasse repräsentiert einen Einkaufswagen.
 *
 * Der Einkaufswagen enthält eine Liste von Produkten, die der Benutzer hinzufügen kann.
 * Es bietet Funktionen zum Hinzufügen und Entfernen von Produkten sowie zum Abrufen der enthaltenen Produkte.
 * Die Liste der Produkte im Einkaufswagen kann nicht direkt geändert werden, um die Unveränderlichkeit zu gewährleisten.
 *
 * @see Serializable
 */
public class ShoppingCart implements Serializable {

    private List<Product> products = new ArrayList<>();

    /**
     * Fügt ein Produkt mit der angegebenen Menge zum Einkaufswagen hinzu.
     *
     * @param product Das hinzuzufügende Produkt.
     * @param quantity Die Menge des Produkts, das hinzugefügt werden soll.
     */
    public void addProduct(Product product, int quantity) {
        products.add(product);
    }

    /**
     * Entfernt ein Produkt aus dem Einkaufswagen.
     *
     * @param product Das zu entfernende Produkt.
     */
    public void remove(Product product) {
        products.remove(product);
    }

    /**
     * Entfernt alle Produkte aus dem Einkaufswagen.
     */
    public void removeAll() {
        products.clear();
    }

    /**
     * Gibt eine unveränderliche Liste der Produkte im Einkaufswagen zurück.
     *
     * @return Eine unveränderliche Liste der Produkte im Einkaufswagen.
     */
    public List<Product> getProducts() {

        return Collections.unmodifiableList(products);
    }
}
