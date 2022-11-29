# Order Summary and Sales Tax Calculation
- Takes input file containing items with their price and description.
- Extracts item name, quantity, and price for each item.
- Computes sales tax applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. 
- Computes Import duty as an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
- Checks for each item if the item is in an Excepted category or imported
- Computes Total SalesTaxes and Total Amount for baskets
- Unit tests for taxes calculations



# Classes
- Main Class: order/OrderSummary.java: Calculates and prints orders summary for all three input files 
- order/receipt/OrderReceiptDetails.java: Contains Computation methods of taxes and printing order summary
- order/receipt/OrderReceiptTest.java : Run JUnit tests for each input file
- order/receipt/items/Item.java: class parses/ saves the properties for every item in orders

# Data 
- OrderData:  Input files for containing items with their price and description.  




# Console Output Preview
![image](https://user-images.githubusercontent.com/38283252/204438132-d1e5ab06-5700-4a60-b97b-8edecda7ea9c.png)

# Program Configurations
- Solution Implemented using Java (JavaSE-1.8)
- IDE framework used for implementation and testing: Eclipse
- External Libraries - JUnit5.9.2

