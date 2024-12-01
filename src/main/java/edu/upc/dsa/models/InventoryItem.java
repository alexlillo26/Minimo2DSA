package edu.upc.dsa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryItem {

    @JsonProperty("item")
    private Item item;

    @JsonProperty("quantity")
    private int quantity;


    public InventoryItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InventoryItem [item=" + item.toString() + ", quantity=" + quantity + "]";
    }
}