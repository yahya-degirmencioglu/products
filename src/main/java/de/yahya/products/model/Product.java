package de.yahya.products.model;

import java.io.Serializable;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
/**
 * Diese Klasse repräsentiert ein Produkt.
 *
 * Ein Produkt ist eine Entität, die in der Datenbank gespeichert wird.
 * Es enthält Informationen wie Name, Beschreibung, Preis und Menge.
 *
 * @see Entity
 * @see Table
 */

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Die eindeutige ID des Produkts.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Der Name des Produkts.
     * Das Feld ist auf 120 Zeichen begrenzt.
     * Es darf nicht leer sein und muss zwischen 1 und 100 Zeichen lang sein.
     */
    @Column(length = 120/*, nullable = false */) // bak
    @NotEmpty(message = "{validate.string.min}") // bak
    @Size(min = 1, max = 100, message = "{validate.string.max}") // bak
    private String name;

    /**
     * Die Beschreibung des Produkts.
     * Das Feld ist auf 800 Zeichen begrenzt.
     * Die Beschreibung muss mindestens 2 Zeichen und höchstens 800 Zeichen lang sein.
     */
    @Column(length = 800)
    @Size(min = 2, max = 800)
    private String description;

    /**
     * Der Preis des Produkts.
     * Der Preis muss positiv sein.
     */
    @Positive
    private double price;

    /**
     * Die Anzahl des Produkts.
     * Die Anzahl muss positiv sein.
     */
    @Positive
    private int quantity;


   /* public String getPriceDE() {
        DecimalFormat priceFmt = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);
        priceFmt.setMaximumFractionDigits(2);
        return priceFmt.format(price);
    }*/
    /**
     * Gibt eine textuelle Darstellung des Produkts zurück.
     *
     * @return Eine textuelle Darstellung des Produkts.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
