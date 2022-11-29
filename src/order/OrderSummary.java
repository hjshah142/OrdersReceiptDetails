package order;

import java.io.IOException;
import java.util.List;
import order.receipt.OrdersReceiptDetails;

public class OrderSummary {
	/**
	 * Class find the order summary from the input files,
	 * calculates the taxes for the items and prints order summary
	 */


	public static void main(String[] args) throws IOException {
		//
		
		
		String[] inputfilesPath = new String[] { "Orderdata/Input1.txt",
				"Orderdata/Input2.txt","Orderdata/Input3.txt"};
		
		
		for(int i=0; i<inputfilesPath.length;i++){
			System.out.printf("Input %d\n", i+1);

			OrdersReceiptDetails order1 = new OrdersReceiptDetails();
			List<String> item_list  = order1.readItemDetails(inputfilesPath[i]);
			// System.out.println(items.toArray().toString());
			order1.findOrderSummary(item_list);
			order1.CalculateOrderSummary();
			order1.printOrderSummary();
			System.out.println();
		}
			


		
	}

}
