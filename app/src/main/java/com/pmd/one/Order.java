package com.pmd.one;

import java.io.Serializable;

public class Order implements Serializable {
    String userName;
    String goodsName;
    int quantity;
    double price;
    double orderPrice;

    public Order(String userName, String goodsName, int quantity, double price, double orderPrice){
        this.userName = userName;
        this.goodsName = goodsName;
        this.quantity = quantity;
        this.price = price;
        this.orderPrice = orderPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
}

