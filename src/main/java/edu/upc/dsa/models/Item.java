package edu.upc.dsa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item implements Comparable<Item> {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private int price;

    @JsonProperty("imageUrl")
    private String imageUrl;

    public Item() {}

    public Item(String id, String name, String description, int price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int compareTo(Item other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", imageUrl=" + imageUrl + "]";
    }
}
