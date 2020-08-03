package com.twu.refactoring;

public class Utils {

    private static final double SALES_TAX =  .10;

    public static StringBuilder calculateTotalTax(Order order) {
        StringBuilder sb = new StringBuilder();
        double totSalesTx = 0d;
        double totAmount = 0d;

        for (LineItem lineItem : order.getLineItems()) {
            appendWithTab(sb, lineItem.getDescription());
            appendWithTab(sb, Double.toString(lineItem.getPrice()));
            appendWithTab(sb, Integer.toString(lineItem.getQuantity()));
            appendWithEnter(sb, Double.toString(lineItem.totalAmount()));

            double salesTax = lineItem.totalAmount() * SALES_TAX;
            totSalesTx += salesTax;

            totAmount += lineItem.totalAmount() + salesTax;

        }
        order.setTotAmount(totAmount);
        order.setTotSalesTx(totSalesTx);
        return sb;
    }

    public static StringBuilder appendWithTab(StringBuilder sb, String string) {
        sb.append(string).append("\t");
        return sb;
    }

    public static StringBuilder appendWithEnter(StringBuilder sb, String string) {
        sb.append(string).append("\n");
        return sb;
    }
}
