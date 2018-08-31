package lambda;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DBUtils {
    public static final String usersDB = "src/main/db/users.json";

    public static void userRegistration(User user){
        Map<UUID, User> users = readUsers();
        users.put(user.getKey(), user);
        writeUsers(users);
    }

    public static void updateUser(User user){
        Map<UUID, User> users = readUsers();
        users.put(user.getKey(), user);
        writeUsers(users);
    }

    private static Map<UUID, User> readUsers() {
        Map<UUID, User> users;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBUtils.usersDB))) {
            Gson gson = new Gson();
            Type mapType = new TypeToken<HashMap<UUID, User>>() {
            }.getType();
            users = gson.fromJson(bufferedReader, mapType);
        } catch (IOException e) {
            users = new HashMap<UUID, User>();
            System.out.println("READ ERROR");
        }
        return users;
    }

    private static void writeUsers(Map<UUID, User> users){
        Gson gson = new Gson();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DBUtils.usersDB))){
            bufferedWriter.write(gson.toJson(users));
            bufferedWriter.flush();
        }
        catch (IOException e){
            System.out.println("WRITE ERROR");
        }
    }

    public static User getUser(UUID key){
        Map<UUID, User> users = readUsers();
        return users.get(key);
    }
}
