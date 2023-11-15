/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcartniemo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TotalPriceSystem {
    public static void main(String[] args) {
        // Product names and prices
           ArrayList<Integer> intList = new ArrayList<Integer>();
        boolean keepGoing = true;
        int total = 0;
        JOptionPane.showMessageDialog(null,"Welcome to Emo's exotic Store","Welcome", JOptionPane.PLAIN_MESSAGE);
        while (keepGoing) {
            String choiceStr = JOptionPane.showInputDialog(
                    "Menu - Managing a List\n"
                            + "1 Add an item to your cart\n"
                            + "2 Exit\n"
                            + "Select a menu option" );
 int choice = 0;
          try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 6.");
                continue;
            }
        switch (choice) {
                case 1:
                String[] products = {"Kanding-50", "Sherk-100", "Dinasour-500", "Cabao-80", "Combirp-30"};
        double[] prices = {50.00, 100.00, 500.00, 80.00, 30.00};

        String selectedProducts = ""; // To store selected products
        double totalPrice = 0.0;

        while (true) {
            String pili = (String) JOptionPane.showInputDialog(null, "Select a product or click cancel to total", "Total Price System",
                    JOptionPane.PLAIN_MESSAGE, null, products, products[0]);

            // Exit the loop if the user cancels or closes the dialog
            if (pili == null) {
                break;
            }

            double productPrice = 0.0;
            for (int i = 0; i < products.length; i++) {
                if (pili.equals(products[i])) {
                    productPrice = prices[i];
                    break;
                }
            }
        String quantityStr = JOptionPane.showInputDialog("Enter the quantity for " + choice + ":");
            if (quantityStr == null) {
                break;
            }

            try {
                int quantity = Integer.parseInt(quantityStr);
                double productTotal = productPrice * quantity;

                // Add the selected product to the list
                selectedProducts += choice + " x " + quantity + " = $" + productTotal + "\n";

                // Add the product total to the running total
                totalPrice += productTotal;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid quantity. Please enter a valid number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
  double discount = 0.0;
        if (totalPrice >= 300) {
            discount = 0.1 * totalPrice; // 10% discount if total amount kung subra 100
        } else if (totalPrice <= 299) {
            discount = 0.05 * totalPrice; // 5% discount if total amount kung less 100
        }
        
        // Calculating the final amount after discount
        double finalAmount = totalPrice - discount;
        
        // Displaying the discount and final amount using JOptionPane
        JOptionPane.showMessageDialog(null, "Total amount: $" + totalPrice +
                "\nDiscount: $" + discount +
                "\nFinal amount after discount: $" + finalAmount);
        // Display the selected products and total
        String message = "Selected Products:\n" + selectedProducts + "\nFinal amount after discount: $" + finalAmount;
        JOptionPane.showMessageDialog(null, message, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
          String bayrunon = "\nFinal amount after discount: $" + finalAmount ;
        String totalCostString = JOptionPane.showInputDialog(null,bayrunon,"\nEnter Value Below", JOptionPane.INFORMATION_MESSAGE );   
         JOptionPane.showMessageDialog(null,"BAYAD SA CHUY!!","CASHIER...", JOptionPane.PLAIN_MESSAGE);
          
        double totalCost = Double.parseDouble(totalCostString);

        // Get the amount paid by the customer
         String amountPaidString = JOptionPane.showInputDialog("pila imong kwarta?");
        double amountPaid = Double.parseDouble(amountPaidString);

        // Calculate the change
        double change = amountPaid - totalCost;

        // Display the change to the customer
        if (change >= 0) {
            JOptionPane.showMessageDialog(null, "sukli nimo kay $" + change);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient amount paid. Please provide more funds.");
        }
        }
         int input = 0;
         
                    try {
                        input = Integer.parseInt(choiceStr);
                        intList.add(input);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    }

                    break;
            case 2:
                    keepGoing = false;
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    break;
        
                default:
                    JOptionPane.showMessageDialog(null, "Enter a value between 1 and 2 that correspods to what you want to do.");
                    break;
    }
        }
    }
}
