/**
 * 
 */
package order.receipt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import order.receipt.items.Item;

/**
 * @author Shah Harsh
 *
 */
public class OrdersReceiptDetails {

	/**
	 * Class calculates the taxes for the items and prints order summary
	 */
	double imported_tax_rate = 0.05;
    double sales_tax_rate = 0.10;
    private static Double TotalSalesTax= 0.00;
	private static Double TotalAmount= 0.00;
	private static ArrayList<Item> ItemsList = new ArrayList<>();
	
	
	
	public OrdersReceiptDetails() {
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// System.out.println("Order Details");
		String input_file_name = "Input2.txt";
		List<String> items =  readItemDetails(input_file_name);
		// System.out.println(items.toString());
		for(int i=0; i< items.size();i++)
		{
			String item_order = items.get(i);
			// System.out.print(item_order);
			List<String> item_order_words =  Arrays.asList(item_order.split(" "));
			int item_qty = Integer.parseInt(item_order_words.get(0));
			//System.out.println(item_qty);
			String item_price_string = item_order_words.get(item_order_words.size()-1);
		    double item_price =  Double.parseDouble(item_price_string); 
			//System.out.println(item_price);
			String item_name = item_order.replace(item_price_string, "");
			item_name = item_name.replace(" at", "");
			// System.out.println(item_name); 
			Item item_obj; 
			

			item_obj = new Item(item_qty, item_name, item_price);
			if(item_name.contains("imported")) {
				item_obj.setItemImported(true);
			}
			if(item_name.contains("book") || item_name.contains("chocolate") || item_name.contains("pills")) {
				item_obj.setItemExempted(true);
			}

			ItemsList.add(item_obj);

			
		}
		// calculating tax for each items and printing order summary
		printOrderSummary();


	}
	


	private static void printOrderSummary() {

		// TODO Auto-generated method stub
        for (Item item : ItemsList) {
        	    	
        	
        	// calculate tax for the item
        	double itemTaxRounded = calculateTax(item);
        	double item_cost = item.getItem_price();
        	double itemCostwithTax = itemTaxRounded + item_cost;
        	// double itemCostwithTaxRounded = roundDoubleValue(itemCostwithTax);
        	
        	// Set item cost after calculating tax 
        	item.setItem_price(itemCostwithTax);
        	TotalSalesTax = itemTaxRounded + TotalSalesTax;
        	//TotalSalesTax = roundDoubleValue(TotalSalesTax);
        	TotalAmount = itemCostwithTax + TotalAmount;
        	
        	System.out.printf("%s: %.2f  \n",item.getItem_name(), item.getItem_price());

        }
        System.out.printf("Sales Taxes: %f",TotalSalesTax);
        System.out.printf("\nTotal: %.2f",TotalAmount);
	
	}
	


	

	private static double calculateTax(Item item) {
		
		// TODO Auto-generated method stub
		double salesTax = 0.00;
    	double importDuty = 0.00;
       	double item_price = item.getItem_price();
    	//System.out.println(item_price);
    	double item_cost = item_price * item.getItem_qty();
    	item.setItem_price(item_cost);
    	
    	if(!item.isItemExempted()) {
    		salesTax = item_cost * 0.10;
    		//salesTax = roundDoubleValue(salesTax);
    		
    	}
    	if(item.isItemImported()) {
    		importDuty = item_cost *0.05;
    		//importDuty = roundDoubleValue(importDuty);
    	}
    	double itemTax = salesTax + importDuty;
    	double itemTaxRounded = roundDoubleValue(itemTax);
    	return itemTaxRounded;
		
	}

	private static double roundDoubleValue(double value) {
		// TODO Auto-generated method stub
		double rounded = Math.round(value * 20.0) / 20.0;
		return rounded;
	}

	private static List<String> readItemDetails(String input_file_name) throws IOException {
		// TODO Auto-generated method stub
		Path fileName= Path.of("OrderData/Input3.txt");
		String fileContent = Files.readString(fileName);
		//System.out.println(fileContent);
		List<String> items = Arrays.asList(fileContent.split("\n"));
		return items;
		
	}

}
