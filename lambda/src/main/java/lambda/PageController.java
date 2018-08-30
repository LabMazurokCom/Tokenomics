package lambda;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PageController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/reg")
    public String registration(@RequestParam(value = "name") String name){
        User user = new User(name);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DBUtils.usersDB))){
            Gson gson = new Gson();
            Type listType = new TypeToken<List<User>>(){}.getType();
            List<User> users = gson.fromJson(bufferedReader, listType);
            users.add(user);
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DBUtils.usersDB))){
                bufferedWriter.write(gson.toJson(users));
                bufferedWriter.flush();
            }
        }
        catch (IOException e){

        }
        return user.getKey().toString();
    }
}