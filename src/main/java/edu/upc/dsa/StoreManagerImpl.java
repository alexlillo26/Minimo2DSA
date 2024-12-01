
package edu.upc.dsa;


import edu.upc.dsa.models.Item;
import edu.upc.dsa.models.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StoreManagerImpl implements  StoreManager {
    private static StoreManagerImpl instance;
    private List<Item> items;




    private StoreManagerImpl() {
        items = new LinkedList<>();
        // Initialize with some items if necessary
        items.add(new Item("1", "Laptop", "High performance laptop", 1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGoQDLRQCgfedvcfRBgWol-dXTJ4IpIGgppg&s"));
        items.add(new Item("2", "Smartphone", "Latest model smartphone", 800, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6t0zst_7dmMNi-eJBK58VuHLee0Q5PBQatg&s"));
        items.add(new Item("3", "Headphones", "Noise-cancelling headphones", 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2FKeSgIbsF64rqq-7OrmYxyq3k0a-TXnklg&s"));
    }

    public static StoreManagerImpl getInstance() {
        if (instance == null) {
            instance = new StoreManagerImpl();
        }
        return instance;
    }
    public Item getItembyId(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findAllItems() {
        return new ArrayList<>(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void deleteItem(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }
}