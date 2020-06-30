package manager;

import models.User;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    private Map<String, User> db;

    public AccountManager() {
        db = new HashMap<String, User>();
        createUsersForTests();
    }

    private void createUsersForTests() {
        db.put("Patrick", new User("Patrick", "1234"));
        db.put("Molly", new User("Molly", "FloPup"));
    }

    public boolean userNameExists(String userName) {
        return db.containsKey(userName);
    }

    public void createUser(User user) {
        db.put(user.getName(), user);
    }

    public boolean validCredentials(User user) {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        System.out.println(db.get(user.getName()));
        return user != null && user.equals(db.get(user.getName()));
    }
}
