package de.yahya.products;


import de.yahya.products.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ProductApplicationTest {

	private Product product;
	/**
	 * Konfiguration vor jedem Test.
	 */
	@BeforeEach
	public void setUp() {
		product = new Product();
	}

	/**
	 * Testet die setId und getId Methoden.
	 */
	@Test
	public void testSetAndGetId() {
		product.setId(4L);
		assertEquals(4L, product.getId());
	}

	/**
	 * Testet die setName und getName Methoden.
	 */
	@Test
	public void testSetAndGetName() {
		product.setName("Testprodukt");
		assertEquals("Testprodukt", product.getName());
	}

	/**
	 * Testet die setDescription und getDescription Methoden.
	 */
	@Test
	public void testSetAndGetDescription() {
		product.setDescription("Das ist ein Testprodukt.");
		assertEquals("Das ist ein Testprodukt.", product.getDescription());
	}

	/**
	 * Testet die setPrice und getPrice Methoden.
	 */
	@Test
	public void testSetAndGetPrice() {
		product.setPrice(10.99);
		assertDoubleEquals(10.99, product.getPrice());
	}
	/**
	 * Testet die setQuantity und getQuantity Methoden.
	 */
	@Test
	public void testSetAndGetQuantity() {
		product.setQuantity(5);
		assertEquals(5, product.getQuantity());
	}

	/* @Test
	public void testGetPriceDE() {
		product.setPrice(10.99);
		assertEquals("10,99", product.getPriceDE());
	}

	@Test
	public void testToString() {
		product.setId(4L);
		product.setName("Testprodukt");
		product.setDescription("Das ist ein Testprodukt.");
		product.setPrice(10.99);
		product.setQuantity(5);

		String expectedString = "Product{id=4, name='Testprodukt', description='Das ist ein Testprodukt.', price=10.99', quantity=5}";
		assertEquals(expectedString, product.toString());
	} */

	/**
	 * Helfermethode zum Überprüfen, ob double-Werte ungefähr gleich sind.
	 *
	 * @param expected Erwarteter Wert.
	 * @param actual Tatsächlicher Wert.
	 */
	private void assertDoubleEquals(double expected, double actual) {
			assertEquals(expected, actual, 0.01);
	}
}