package junit_tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import model.RefurbishedStore;

import org.junit.Test;

import model.*;

public class TestRefurbishedStore {

	@Test
	public void test_refurbished_store_1() {
		// Create an empty store.
		RefurbishedStore rs = new RefurbishedStore();  // Max. 5 Entries
		
		assertTrue(rs.getNumberOfEntries() == 0);
		assertTrue(rs.getPrivateEntriesArray().length == 5);
		
		assertTrue(rs.getPrivateEntriesArray()[0] == null);
		assertTrue(rs.getPrivateEntriesArray()[1] == null);
		assertTrue(rs.getPrivateEntriesArray()[2] == null);
		assertTrue(rs.getPrivateEntriesArray()[3] == null);
		assertTrue(rs.getPrivateEntriesArray()[4] == null);
		assertTrue(rs.getEntries().length == 0);
		
		Product p1 = new Product("iPad Pro 12.9", 1709.00);
		p1.setFinish("Space Grey");
		p1.setStorage(1000); // 1TB
		p1.setHasCellularConnectivity(true);
		p1.setDiscountValue(220.00);
		Entry e1 = new Entry("F9FDN4NKQ1GC", p1);
		
		// Add Entry 1. 
		rs.addEntry(e1);
		assertTrue(rs.getNumberOfEntries() == 1);
		assertTrue(rs.getPrivateEntriesArray().length == 5);
		assertTrue(rs.getPrivateEntriesArray()[0] == e1);
		assertTrue(rs.getPrivateEntriesArray()[1] == null);
		assertTrue(rs.getPrivateEntriesArray()[2] == null);
		assertTrue(rs.getPrivateEntriesArray()[3] == null);
		assertTrue(rs.getPrivateEntriesArray()[4] == null);
		
		assertTrue(rs.getEntries().length == 1);
		assertTrue(rs.getEntries()[0] == e1);
		

		// Add Entry 2.
		Product p2 = new Product("iPad Air", 649.00);
		p1.setFinish("Gold");
		p1.setStorage(64); 
		p1.setHasCellularConnectivity(false);
		p1.setDiscountValue(100.00);
		rs.addEntry("C9FZ4J8QC82", p2);
		assertTrue(rs.getPrivateEntriesArray().length == 5);
		assertTrue(rs.getPrivateEntriesArray()[0] == e1);
		assertTrue(rs.getPrivateEntriesArray()[1].getSerialNumber().equals("C9FZ4J8QC82"));
		assertTrue(rs.getPrivateEntriesArray()[1].getProduct() == p2);
		assertTrue(rs.getPrivateEntriesArray()[2] == null);
		assertTrue(rs.getPrivateEntriesArray()[3] == null);
		assertTrue(rs.getPrivateEntriesArray()[4] == null);
		
		assertTrue(rs.getEntries().length == 2);
		assertTrue(rs.getPrivateEntriesArray()[0] == e1);
		assertTrue(rs.getPrivateEntriesArray()[1].getSerialNumber().equals("C9FZ4J8QC82"));
		assertTrue(rs.getPrivateEntriesArray()[1].getProduct() == p2);

		// Add Entry 3
		rs.addEntry("7YM4PFZ779UB", "iPad Pro 10.5", 929.00);
		assertTrue(rs.getNumberOfEntries() == 3);
		assertTrue(rs.getPrivateEntriesArray().length == 5);
		assertTrue(rs.getPrivateEntriesArray()[0] == e1);
		assertTrue(rs.getPrivateEntriesArray()[1].getSerialNumber().equals("C9FZ4J8QC82"));
		assertTrue(rs.getPrivateEntriesArray()[1].getProduct() == p2);
		assertTrue(rs.getPrivateEntriesArray()[2].getProduct().getModel().equals("iPad Pro 10.5"));
		assertEquals(929.00, rs.getPrivateEntriesArray()[2].getProduct().getOriginalPrice(), 0.1);
		assertTrue(rs.getPrivateEntriesArray()[3] == null);
		assertTrue(rs.getPrivateEntriesArray()[4] == null);
		
		assertTrue(rs.getEntries().length == 3);
		assertTrue(rs.getEntries()[0] == e1);
		assertTrue(rs.getEntries()[1].getSerialNumber().equals("C9FZ4J8QC82"));
		assertTrue(rs.getEntries()[1].getProduct() == p2);
		assertTrue(rs.getEntries()[2].getProduct().getModel().equals("iPad Pro 10.5"));
		assertEquals(929.00, rs.getEntries()[2].getProduct().getOriginalPrice(), 0.1);
		
		assertEquals(null, rs.getProduct("adsf"));
		assertEquals(rs.getPrivateEntriesArray()[1].getProduct(), rs.getProduct("C9FZ4J8QC82"));
	}
	
	@Test
	public void test_refurbished_store_2() {
		// Create an empty store.
		RefurbishedStore rs = new RefurbishedStore();  // Max. 5 Entries
		
		Product p1 = new Product("iPad Pro 12.9", 1709.00);
		p1.setFinish("Space Grey");
		p1.setStorage(1000); // 1TB
		p1.setHasCellularConnectivity(true);
		p1.setDiscountValue(220.00);
		Entry e1 = new Entry("F9FDN4NKQ1GC", p1);
		
		// Add Entry 1. 
		rs.addEntry(e1);
		

		// Add Entry 2.
		Product p2 = new Product("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64); 
		p2.setHasCellularConnectivity(false);
		p2.setDiscountValue(100.00);
		rs.addEntry("C9FZ4J8QC82", p2);
		
		// Add Entry 3
		rs.addEntry("7YM4PFZ779UB", "iPad Pro 10.5", 929.00);
		rs.getEntries()[2].getProduct().setFinish("Silver");;
		rs.getEntries()[2].getProduct().setStorage(1000);
		rs.getEntries()[2].getProduct().setHasCellularConnectivity(false);;
		rs.getEntries()[2].getProduct().setDiscountValue(220.00);;
		
		assertTrue(rs.getProduct("F9FDN4NKQ1GC") == p1);
		assertTrue(rs.getProduct("C9FZ4J8QC82") == p2);
		assertTrue(rs.getProduct("F9FDN4NKQ1GC") == rs.getEntries()[0].getProduct());	
		assertTrue(rs.getProduct("F9FDN4NKQ1GC").getModel().equals("iPad Pro 12.9"));		
		assertTrue(rs.getProduct("F9FDN4NKQ1GC").getStorage() ==  1000);
		assertTrue(rs.getProduct("F9FDN4NKQ1GC").getFinish() ==  "Space Grey");
		assertTrue(rs.getProduct("F9FDN4NKQ1GC").hasCellularConnectivity() ==  true);
		assertEquals(1709.00, rs.getProduct("F9FDN4NKQ1GC").getOriginalPrice(), 0.1);
		assertEquals(220.0, rs.getProduct("F9FDN4NKQ1GC").getDiscountValue(), 0.1);
		
		rs.getProduct("F9FDN4NKQ1GC").setFinish("Silver");
		rs.getProduct("F9FDN4NKQ1GC").setStorage(256);
		
		Product p3 = rs.getEntries()[2].getProduct();
		p3.setHasCellularConnectivity(false);
		p3.setDiscountValue(270.00);
		
		assertTrue(rs.getProduct("C9FZ4J8QC82") == rs.getEntries()[1].getProduct());	
		assertTrue(rs.getProduct("C9FZ4J8QC82").getModel().equals("iPad Air"));		
		assertTrue(rs.getProduct("C9FZ4J8QC82").getStorage() ==  64.00);
		assertTrue(rs.getProduct("C9FZ4J8QC82").getFinish() ==  "Gold");
		assertTrue(rs.getProduct("C9FZ4J8QC82").hasCellularConnectivity() ==  false);
		assertEquals(649.00, rs.getProduct("C9FZ4J8QC82").getOriginalPrice(), 0.1);
		assertEquals(100.0, rs.getProduct("C9FZ4J8QC82").getDiscountValue(), 0.1);
	}
	
	@Test
	public void test_refurbished_store_3() {
		// Create an empty store.
		RefurbishedStore rs = new RefurbishedStore();  // Max. 5 Entries
		
		Product p1 = new Product("iPad Pro 12.9", 1709.00);
		p1.setFinish("Space Grey");
		p1.setStorage(1000); // 1TB
		p1.setHasCellularConnectivity(true);
		p1.setDiscountValue(220.00);
		Entry e1 = new Entry("F9FDN4NKQ1GC", p1);
		
		// Add Entry 1. 
		rs.addEntry(e1);
		

		// Add Entry 2.
		Product p2 = new Product("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64); 
		p2.setHasCellularConnectivity(false);
		p2.setDiscountValue(100.00);
		rs.addEntry("C9FZ4J8QC82", p2);
		
		// Add Entry 3
		rs.addEntry("7YM4PFZ779UB", "iPad Pro 10.5", 929.00);
		rs.getEntries()[2].getProduct().setFinish("Silver");;
		rs.getEntries()[2].getProduct().setStorage(1000);
		rs.getEntries()[2].getProduct().setHasCellularConnectivity(false);;
		rs.getEntries()[2].getProduct().setDiscountValue(220.00);;
		
		assertTrue(rs.getSpaceGreyOrPro().length == 2);
		assertTrue(rs.getSpaceGreyOrPro()[0].equals("F9FDN4NKQ1GC")
				&&
				rs.getSpaceGreyOrPro()[1].equals("7YM4PFZ779UB"));
		
		assertTrue(rs.getSpaceGreyPro().length == 1);
		assertTrue(rs.getSpaceGreyPro()[0].equals("F9FDN4NKQ1GC"));

	}
	
	

}




















