/**
 * 
 */
package order.receipt;

import java.io.FileNotFoundException;
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
	 * Class find the order summary from the input files,
	 * calculates the taxes for the items and prints order summary
	 */

    public  Double TotalSalesTax= 0.00;
	public  Double TotalAmount= 0.00;
	private  ArrayList<Item> ItemsList = new ArrayList<>();
	static double  imported_tax_rate = 0.05;
	static double sales_tax_rate = 0.10;
	


	public OrdersReceiptDetails() {
		
	    
		
		// TODO Auto-generated constructor stub
	}


	
	public void findOrderSummary(List<String> itemStringlist) {

		
		for(int i=0; i< itemStringlist.size();i++)
		{
			String item_order = itemStringlist.get(i);
			// System.out.print(item_order);
			// spliting string with coma to find different word
			List<String> item_order_words =  Arrays.asList(item_order.split(" "));
			int item_qty = Integer.parseInt(item_order_words.get(0));
			//System.out.println(item_qty);
			String item_price_string = item_order_words.get(item_order_words.size()-1);
		    double item_price =  Double.parseDouble(item_price_string); 
			//System.out.println(item_price);
			String item_name = item_order.replace(item_price_string, "");
			// Remove the word at from the item string 
			// another way is to find 2nd last word and remove
			item_name = item_name.replace(" at", "");
			// System.out.println(item_name); 
			Item item_obj = new Item(item_qty, item_name, item_price);
			if(item_name.contains("imported")) {
				// find it item is imported or not
				item_obj.setItemImported(true);
			}
			// TODO other keywords can be added to check if excepted 
			if(item_name.contains("book") || item_name.contains("chocolate") || item_name.contains("pills")) {
				item_obj.setItemExempted(true);
			}

			ItemsList.add(item_obj);

			
		}
		//System.out.println(ItemsList.size());
		
	}


	public void CalculateOrderSummary() {
		// calculate sales taxes and total bill amount 


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
        	
        }
        
        
	
	}
	public void printOrderSummary(){
		
        for (Item item : ItemsList) {      	 
        	
        	System.out.printf("%s: %.2f  \n",item.getItem_name(), item.getItem_price());
        }
        System.out.printf("Sales Taxes: %.2f",TotalSalesTax);
        System.out.printf("\nTotal: %.2f\n",TotalAmount);
		
	}
	


	private static double calculateTax(Item item) {
		
		double salesTax = 0.00;
    	double importDuty = 0.00;
       	double item_price = item.getItem_price();
    	//System.out.println(item_price);
    	double item_cost = item_price * item.getItem_qty();
    	item.setItem_price(item_cost);
    	
    	if(!item.isItemExempted()) {
    		salesTax = item_cost * sales_tax_rate;
    		//salesTax = roundDoubleValue(salesTax);
    		
    	}
    	if(item.isItemImported()) {
			importDuty = item_cost * imported_tax_rate ;
    		//importDuty = roundDoubleValue(importDuty);
    	}
    	double itemTax = salesTax + importDuty;
    	double itemTaxRounded = roundDoubleValue(itemTax);
    	return itemTaxRounded;
		
	}

	private static double roundDoubleValue(double value) {
		// TODO Auto-generated method stub
		double rounded = Math.round(value * 20.00) / 20.0;
		return rounded;
	}

	public List<String> readItemDetails(String input_file_name)  {
		// reads from the file and saves result  to string list
		String fileContent = "";
		Path fileName= Path.of(input_file_name);
		try {
			fileContent = Files.readString(fileName);
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(fileContent);
		List<String> itemList = Arrays.asList(fileContent.split("\n"));
		return itemList;
		
	}






}
