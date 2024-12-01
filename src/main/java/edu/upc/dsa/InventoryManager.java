package edu.upc.dsa;

import edu.upc.dsa.models.Inventory;
import edu.upc.dsa.models.Item;
import edu.upc.dsa.models.InventoryItem;

import java.util.List;

public interface InventoryManager {
    Inventory addInventory(Inventory inventory);
    Inventory addItemToInventory(String inventoryId, String itemId, int quantity);
    Inventory getInventory(String id);
    InventoryItem getInventoryItemId(String id);
    List<InventoryItem> findAllInventoryItem();
    List<Inventory> findAllInventory();
    List<Item> getItemsFromInventoryItems(List<InventoryItem> inventoryItems);
    List<Item> getItemsFromInventoryById(String inventoryId);
    List<Item> findAllItems();
    void clear();
    int size();
}