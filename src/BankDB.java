import java.util.HashMap;

public class BankDB {
    public static HashMap<String, User> users = new HashMap<>();
    public static boolean checkUserame(String username){
        return users.containsKey(username);
    }

    public static void createUser(String username, String password){
        users.put(username,new User(username,password));
    }

    public static User findByUsername(String username){
        return users.get(username);
    }
}
