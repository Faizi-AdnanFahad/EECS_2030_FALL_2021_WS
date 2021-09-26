package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Product;

public class TestProduct {

	@Test
	public void test_product_1() {
		Product p = new Product();
		
		assertNull(p.getModel());
		assertTrue(p.getFinish() == null);
		assertFalse(p.getFinish() != null); // !(p.getFinish() != null)
		
		assertTrue(p.getStorage() == 0);
		assertFalse(p.getStorage() == 4);
		
		assertEquals(0, p.getStorage());
		
		assertFalse(p.hasCellularConnectivity());
		assertFalse(p.hasCellularConnectivity() == true);
		assertTrue(!p.hasCellularConnectivity()); // assertTrue(p.hasCellularConnectivity() == false); // assertTrue(p.hasCellularConnectivity() != true); 
		
		// Decimal numbers, when stored in the computer memory, cannot be represented in binary perfectly.
		// Instead, we should allow for some TOLERANCE of calculated result (e.g., +/- 0.1)
		assertEquals(0.0, p.getOriginalPrice(), 0.1);
//		assertTrue(0.0 == p.getOriginalPrice()); // Compilable but not recommended, tolerance should be allowed
		
		assertEquals(0.0, p.getPrice(), 0.0);
		
		assertEquals("null null 0GB (cellular connectivity: false): $(0.00 - 0.00)", p.toString());
	}
	
	@Test
	public void test_product_2() {
		Product p = new Product("iPad Pro 12.9", 1709.00);
		
		assertNotNull(p.getModel());
		assertEquals("iPad Pro 12.9", p.getModel());
		assertTrue(p.getModel().equals("iPad Pro 12.9"));
//		assertTrue(p.getModel() == "iPad Pro 12.9"); // This does not neccesserily work always. because String is non - primitive data type
		
		assertTrue(p.getFinish() == null);
		assertFalse(p.getFinish() != null); // !(p.getFinish() != null)
		
		assertTrue(p.getStorage() == 0);
		assertFalse(p.getStorage() == 4);
		
		assertEquals(0, p.getStorage());
		
		assertFalse(p.hasCellularConnectivity());
		assertFalse(p.hasCellularConnectivity() == true);
		assertTrue(!p.hasCellularConnectivity()); // assertTrue(p.hasCellularConnectivity() == false); // assertTrue(p.hasCellularConnectivity() != true); 
		
		// Decimal numbers, when stored in the computer memory, cannot be represented in binary perfectly.
		// Instead, we should allow for some TOLERANCE of calculated result (e.g., +/- 0.1)
		assertEquals(1709.0, p.getOriginalPrice(), 0.1);
//		assertTrue(0.0 == p.getOriginalPrice()); // Compilable but not recommended, tolerance should be allowed
		
		assertEquals(1709.0, p.getPrice(), 0.0);
		
		assertEquals("iPad Pro 12.9 null 0GB (cellular connectivity: false): $(1709.00 - 0.00)", p.toString());
	}
	
	@Test
	public void test_product_3() {
		Product p = new Product("iPad Pro 12.9", 1709.00);
		
		assertNotNull(p.getModel());
		assertEquals("iPad Pro 12.9", p.getModel());
		assertTrue(p.getModel().equals("iPad Pro 12.9"));
//		assertTrue(p.getModel() == "iPad Pro 12.9"); // This does not neccesserily work always. because String is non - primitive data type
		
		p.setFinish("Space Grey");
		
		assertTrue(p.getFinish() == "Space Grey");
		assertTrue(p.getFinish() != null); // !(p.getFinish() != null)
		assertEquals("Space Grey", p.getFinish());
		
		p.setStorage(1000); // 1TB
		
		assertTrue(p.getStorage() == 1000);
		assertEquals(1000, p.getStorage());
		assertFalse(p.getStorage() == 4);
		assertEquals(1000, p.getStorage());
		
		
		p.setHasCellularConnectivity(true);
		assertFalse(!p.hasCellularConnectivity());
		assertFalse(p.hasCellularConnectivity() != true);
		assertTrue(p.hasCellularConnectivity() != false);
		assertTrue(p.hasCellularConnectivity() == true);
		assertTrue((p.hasCellularConnectivity() == true));
		assertTrue(p.hasCellularConnectivity()); // assertTrue(p.hasCellularConnectivity() == false); // assertTrue(p.hasCellularConnectivity() != true); 
		
		// Decimal numbers, when stored in the computer memory, cannot be represented in binary perfectly.
		// Instead, we should allow for some TOLERANCE of calculated result (e.g., +/- 0.1)
		p.setDiscountValue(220);
		assertEquals(220.0, p.getDiscountValue(), 0.1);
		assertEquals(1709.0, p.getOriginalPrice(), 0.1);
//		assertTrue(0.0 == p.getOriginalPrice()); // Compilable but not recommended, tolerance should be allowed
		
		assertEquals(1489.0, p.getPrice(), 0.0);
		
		assertEquals("iPad Pro 12.9 Space Grey 1000GB (cellular connectivity: true): $(1709.00 - 220.00)", p.toString());
	}

}