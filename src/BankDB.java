import java.util.HashMap;

public class BankDB {
    public HashMap<String, User> users = new HashMap<>();
    public boolean checkUserame(String username){
        return this.users.containsKey(username);
    }

    public void createUser(String username, String password){
        this.users.put(username,new User(username,password));
    }

    public User findByUsername(String username){
        return this.users.get(username);
    }
}
