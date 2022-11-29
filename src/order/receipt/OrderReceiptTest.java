package order.receipt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class OrderReceiptTest	 {

	@Test
	void test1() {
		
		OrdersReceiptDetails TestOrder1 = new OrdersReceiptDetails();
		List<String> item_list  = TestOrder1.readItemDetails("Orderdata/Input1.txt");
		// System.out.println(items.toArray().toString());
		TestOrder1.findOrderSummary(item_list);
		TestOrder1.CalculateOrderSummary();
	
        assertEquals(TestOrder1.TotalSalesTax, 1.50,005);
        assertEquals(TestOrder1.TotalAmount, 29.83,0.005);
		
		
	}
	@Test
	void test2() {
		
		OrdersReceiptDetails TestOrder2 = new OrdersReceiptDetails();
		List<String> item_list  = TestOrder2.readItemDetails("Orderdata/Input2.txt");
		// System.out.println(items.toArray().toString());
		TestOrder2.findOrderSummary(item_list);
		TestOrder2.CalculateOrderSummary();
	
        assertEquals(TestOrder2.TotalSalesTax, 7.65,0.005);
        assertEquals(TestOrder2.TotalAmount, 65.15,0.005);
		
		
	}
	@Test
	void test3() {
		
		OrdersReceiptDetails TestOrder3 = new OrdersReceiptDetails();
		List<String> item_list  = TestOrder3.readItemDetails("Orderdata/Input3.txt");
		// System.out.println(items.toArray().toString());
		TestOrder3.findOrderSummary(item_list);
		TestOrder3.CalculateOrderSummary();
	
        assertEquals(TestOrder3.TotalSalesTax, 6.70,0.005);
        assertEquals(TestOrder3.TotalAmount, 74.68,0.005);
		
		
	}


}
