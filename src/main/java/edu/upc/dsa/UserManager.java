package edu.upc.dsa;

import edu.upc.dsa.models.Inventory;
import edu.upc.dsa.models.User;

import java.util.List;

public interface UserManager {
    public User addUser(String username, String password, String isAdmin, String fullName, String email, int age, String profilePicture, int coins);
    public User addUser(String username, String password, String isAdmin);
    public User addUsers(User user);
    public User getUser(String id);
    public User getUserProfileByUsername(String username);
    public List<User> findAll();
    public void deleteUser(String id);
    public User updateUser(User t);
    public void clear();
    public int size();
    public User getUserByUsername(String username);
}