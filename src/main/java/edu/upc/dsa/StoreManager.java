package edu.upc.dsa;


import edu.upc.dsa.models.Item;

import java.util.List;

public interface StoreManager {

        public Item getItembyId(String id);
        public List<Item> findAll();

        public List<Item> findAllItems();

        public void addItem(Item item);

        public void deleteItem(String name);







}
