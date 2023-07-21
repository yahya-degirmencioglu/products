package de.yahya.products.repository;

import de.yahya.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dieses Interface stellt einen JPA-Repository für Produkte dar.
 *
 * Das Interface erweitert das JpaRepository-Interface und erbt dadurch grundlegende CRUD-Funktionen für Produkte.
 * Es ermöglicht den Zugriff auf die Datenbanktabelle, die Produkte speichert.
 *
 * @see JpaRepository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Sucht Produkte anhand des Namens.
     *
     * @param name Der Name, nach dem gesucht werden soll.
     * @return Eine Liste von Produkten, deren Name mit dem angegebenen Namen übereinstimmt.
     */
    List<Product> findByName(String name);

    /**
     * Sucht Produkte, deren Name den angegebenen Wert enthält.
     *
     * @param name Der Wert, der im Namen enthalten sein muss.
     * @return Eine Liste von Produkten, deren Name den angegebenen Wert enthält.
     */
    List<Product> findByNameContaining(String name);

    /**
     * Sucht Produkte, deren Name oder Beschreibung den angegebenen Werten entsprechen.
     *
     * @param name Der Wert, der im Namen enthalten sein muss.
     * @param desc Der Wert, der in der Beschreibung enthalten sein muss.
     * @return Eine Liste von Produkten, deren Name oder Beschreibung den angegebenen Werten entsprechen.
     */
    List<Product> findByNameContainingOrDescriptionContaining(String name, String desc);

}
