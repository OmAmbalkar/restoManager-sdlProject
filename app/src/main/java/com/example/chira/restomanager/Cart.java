package com.example.chira.restomanager;

import java.util.ArrayList;
import java.util.Date;

public class Cart {
    Integer TotalAmount;
    Integer Quantity;
    Date date;
    ArrayList<String> itemList ;
    ArrayList<Integer> itemQuantity;
    ArrayList<Integer> itemAmount;
    public Cart(){
        TotalAmount = 0;
        itemList = new ArrayList<>();
        itemAmount = new ArrayList<>();
        itemQuantity = new ArrayList<>();
    }
    public void setItemQuantity(Integer itemQuant){
        Quantity = itemQuant ;
    }
    public Integer getItemQuantity(){
        return Quantity;
    }
    public void addItemIntoCart(String item, Integer quantity, Integer amount) {
        if(!quantity.equals(0)) {
            itemList.add(item);
            itemQuantity.add(quantity);
            itemAmount.add(amount);
        }
    }
}
