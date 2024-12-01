package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class User {
    private String username;
    private String password;
    private String id;
    private String isAdmin;
    private String fullName;
    private String email;
    private int age;
    private String profilePicture;
    private int coins;
    private Inventory inventory; // Correctly defined as Inventory

    public User() {
        this.setId(RandomUtils.getId());
        this.isAdmin = "notadmin";
        this.coins = 200;
    }

    public User(String username, String password, String isAdmin) {
        this();
        this.setUsername(username);
        this.setPassword(password);
        this.isAdmin = isAdmin;
    }

    public User(String username, String password, String isAdmin, String fullName, String email, int age, String profilePicture, int coins) {
        this(username, password, isAdmin);
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.profilePicture = profilePicture;
        this.coins = coins;
    }

    // Getters and Setters
    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }



    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullName=" + fullName +
                ", email=" + email + ", age=" + age + ", profilePicture=" + profilePicture + ", coins=" + coins + "]";
    }
}