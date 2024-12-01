package edu.upc.dsa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    @JsonProperty("id")
    private String id;

    @JsonProperty("items")
    private List<InventoryItem> inventoryitems ;

    public Inventory(String id) {
        this.id = id;
        this.inventoryitems= new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addIvenventoryItem(InventoryItem inventoryItem) {
        this.inventoryitems.add(inventoryItem);
    }

    public List<InventoryItem> getInventoryitems() {
        return inventoryitems;
    }
    public void setInventoryitems(List<InventoryItem> inventoryitems) {
        this.inventoryitems = inventoryitems;
    }

}