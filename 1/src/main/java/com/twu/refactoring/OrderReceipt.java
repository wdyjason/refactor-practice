package com.twu.refactoring;

import static com.twu.refactoring.Utils.appendWithTab;
import static com.twu.refactoring.Utils.calculateTotalTax;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append("======Printing Orders======\n");

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

		StringBuilder printItems = calculateTotalTax(order);
		output.append(printItems);

		appendWithTab(output, "Sales Tax").append(order.getTotSalesTx());

		appendWithTab(output, "Total Amount").append(order.getTotAmount());
		return output.toString();
	}
}