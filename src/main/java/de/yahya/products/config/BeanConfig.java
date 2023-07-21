package de.yahya.products.config;


import de.yahya.products.model.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Diese Klasse ist eine Konfigurationsklasse, die zum Konfigurieren von Spring Beans verwendet wird.
 *
 * Es konfiguriert die {@link ShoppingCart} Klasse als Spring Bean und stellt sicher, dass sie
 * im Anwendungskontext auf Sitzungsebene (Session Scope) gehalten wird. Dadurch bleibt der
 * Einkaufswagen so lange erhalten, wie die Sitzung des Benutzers aktiv ist.
 *
 * @see ShoppingCart
 */
@Configuration
public class BeanConfig {

    /**
     * Definiert die {@link ShoppingCart} Klasse als Spring Bean und hält sie auf Sitzungsebene (Session Scope).
     *
     * @return Das Einkaufswagen (ShoppingCart) Objekt.
     */
    @Bean
    @SessionScope
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

}
