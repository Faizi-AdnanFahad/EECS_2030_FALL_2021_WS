package junit_tests;

import static org.junit.Assert.*;
import model.Product;
import model.Entry;

import org.junit.Test;

public class TestEntry {

	@Test
	public void test_entry_1() {
		Product p = new Product("iPad Pro 12.9", 1709.00);
		p.setFinish("Space Grey");
		p.setStorage(1000);
		p.setHasCellularConnectivity(true);
		p.setDiscountValue(220.00);

		Entry e = new Entry("F9DN4NKQ1GC", p);
		assertTrue(e.getSerialNumber().equals("F9DN4NKQ1GC"));  // == does not necessarily work		

		assertTrue(e.getProduct() == p);
		assertSame(e.getProduct(), p); // are e.getProduct() and p refereeing to the same Product object (or are they the same Product address)
		assertEquals("[F9DN4NKQ1GC] iPad Pro 12.9 Space Grey 1000GB (cellular connectivity: true): $(1709.00 - 220.00)", e.toString());
		assertEquals("iPad Pro 12.9", e.getProduct().getModel());

		assertTrue(e.getProduct().getModel().equals("iPad Pro 12.9"));
		assertEquals("Space Grey", e.getProduct().getFinish());
		assertTrue(1000 == e.getProduct().getStorage());
		assertTrue(e.getProduct().hasCellularConnectivity());
		assertEquals(1709.00, e.getProduct().getOriginalPrice(), 0.1);
		assertEquals(220.00, e.getProduct().getDiscountValue(), 0.1);
		assertEquals(1489.00, e.getProduct().getPrice(), 0.1);
		assertEquals("iPad Pro 12.9 Space Grey 1000GB (cellular connectivity: true): $(1709.00 - 220.00)", e.getProduct().toString());
	}

	@Test 
	public void test_entry_2() {
		Product p = new Product("iPad Pro 12.9", 1709.00);
		p.setFinish("Space Grey");
		p.setStorage(1000);
		p.setHasCellularConnectivity(true);
		p.setDiscountValue(220.00);

		Entry e = new Entry("F9DN4NKQ1GC", p);
		assertTrue(e.getSerialNumber().equals("F9DN4NKQ1GC"));  // == does not necessarily work		
		assertTrue(e.getProduct() == p);
		assertSame(e.getProduct(), p); // are e.getProduct() and p refereeing to the same Product object (or are they the same Product address)
		assertEquals("[F9DN4NKQ1GC] iPad Pro 12.9 Space Grey 1000GB (cellular connectivity: true): $(1709.00 - 220.00)", e.toString());

		Product p2 = new Product("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64); // GB
		p2.setHasCellularConnectivity(false); // unnecessary
		p2.setDiscountValue(100.00);

		// Change e's associated product from p to p2
		e.setProduct(p2);
		
		assertTrue(e.getSerialNumber().equals("F9DN4NKQ1GC"));  // == does not necessarily work		
		assertTrue(e.getProduct() == p2);
		assertSame(e.getProduct(), p2); // are e.getProduct() and p refereeing to the same Product object (or are they the same Product address)
		assertNotSame(e.getProduct(), p);
		assertEquals("[F9DN4NKQ1GC] iPad Air Gold 64GB (cellular connectivity: false): $(649.00 - 100.00)", e.toString());
		

		// Change e's associated product from p2 to another object;
		e.setProduct("iPad Air", 649.00);
		
		assertTrue(e.getSerialNumber().equals("F9DN4NKQ1GC"));
		assertTrue(e.getProduct() != p2);
		assertNotSame(e.getProduct(), p);
		assertEquals("[F9DN4NKQ1GC] iPad Air null 0GB (cellular connectivity: false): $(649.00 - 0.00)", e.toString());
	}



















}
