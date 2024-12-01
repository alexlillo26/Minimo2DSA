package edu.upc.dsa;

import edu.upc.dsa.models.Inventory;
import edu.upc.dsa.models.InventoryItem;
import edu.upc.dsa.models.Item;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;
import java.util.stream.Collectors;

import java.util.LinkedList;
import java.util.List;

public class InventoryManagerImpl implements InventoryManager {
    private static InventoryManager instance;
    protected List<Inventory> inventories;
    protected List<InventoryItem> InventoryItem;
    protected List<Item> items;
    final static Logger logger = Logger.getLogger(InventoryManagerImpl.class);

    private InventoryManagerImpl() {
        this.inventories = new LinkedList<>();
        this.InventoryItem = new LinkedList<>();
        this.items = new LinkedList<>();
    }

    public List<Item> getItemsFromInventoryItems(List<InventoryItem> inventoryItems) {
        List<Item> items = new LinkedList<>();
        for (InventoryItem inventoryItem : inventoryItems) {
            items.add(inventoryItem.getItem());
        }
        return items;
    }

    public List<Item> getItemsFromInventoryById(String inventoryId) {
        List<Item> items = new LinkedList<>();

        // Recorre la lista de inventarios para encontrar el inventario con la ID dada
        for (Inventory inventory : this.inventories) {
            if (inventory.getId().equals(inventoryId)) {
                // Recorre la lista de InventoryItem de ese inventario
                for (InventoryItem inventoryItem : inventory.getInventoryitems()) {
                    items.add(inventoryItem.getItem());
                }
                break; // Salir del bucle una vez encontrado el inventario
            }
        }

        return items;
    }


    public static InventoryManager getInstance() {
        if (instance == null) instance = new InventoryManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.inventories.size();
        logger.info("size " + ret);
        return ret;
    }

    public Inventory addInventory(Inventory inventory) {
        logger.info("new Inventory " + inventory);
        this.inventories.add(inventory);
        logger.info("new Inventory added");
        return inventory;
    }


    public Inventory addItemToInventory(String inventoryId, String itemId, int quantity) {
        Inventory inventory = this.getInventory(inventoryId);
        if (inventory != null) {
            Item item = StoreManagerImpl.getInstance().getItembyId(itemId);
            if (item != null) {
                InventoryItem inventoryItem = new InventoryItem(item, quantity);
                inventory.addIvenventoryItem(inventoryItem);
                logger.info("Item added to inventory " + inventoryId);
            } else {
                logger.warn("Item not found " + itemId);
            }
        } else {
            logger.warn("Inventory not found " + inventoryId);
        }
        return inventory;
    }






    public List<InventoryItem> findAllInventoryItem() {
        return this.InventoryItem;
    }
    public List<Inventory> findAllInventory() {
        return this.inventories;
    }

    public List<Item> findAllItems() {
        return this.items;
    }

    public Inventory getInventory(String id) {
        logger.info("getInventory(" + id + ")");
        for (Inventory inventory : this.inventories) {
            if (inventory.getId().equals(id)) {
                logger.info("getInventory(" + id + "): " + inventory);
                return inventory;
            }
        }
        logger.warn("not found " + id);
        return null;
    }

    public InventoryItem getInventoryItemId(String itemId) {
        logger.info("getInventoryItemById(" + itemId + ")");
        for (InventoryItem inventoryItem : this.InventoryItem) {
            if (inventoryItem.getItem().getId().equals(itemId)) {
                logger.info("getInventoryItemById(" + itemId + "): " + inventoryItem);
                return inventoryItem;
            }
        }
        logger.warn("not found " + itemId);
        return null;
    }

    public void clear() {
        this.inventories.clear();
        this.InventoryItem.clear();
        this.items.clear();
    }
}