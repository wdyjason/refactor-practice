package com.twu.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String addr;
    List<LineItem> items;
    double totSalesTx;


    double totAmount ;

    public Order(String customerName, String addr, List<LineItem> items) {
        this.customerName = customerName;
        this.addr = addr;
        this.items = items;
        this.totSalesTx = 0d;
        this.totAmount = 0d;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return items;
    }

    public double getTotSalesTx() {
        return totSalesTx;
    }

    public double getTotAmount() {
        return totAmount;
    }

    public void setTotSalesTx(double totSalesTx) {
        this.totSalesTx = totSalesTx;
    }

    public void setTotAmount(double totAmount) {
        this.totAmount = totAmount;
    }
}
