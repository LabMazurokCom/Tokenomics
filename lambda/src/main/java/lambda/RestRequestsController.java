package lambda;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestRequestsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/reg")
    public String registration(@RequestParam(value = "name") String name){
        User user = new User(name);
        DBUtils.userRegistration(user);
        return user.getKey().toString();
    }

    @RequestMapping("/test")
    public String test(@RequestParam(value = "key") UUID key, @RequestParam(value = "time") double time, @RequestParam(value = "lambda") double lambda){
        User user = DBUtils.getUser(key);
        if(user != null){
            if(user.getLastLambda() > time){
                return "WRONG TIME";
            }
            else{
                boolean testResult = Tester.getTester().test(user, time, lambda);
                DBUtils.updateUser(user);
                return Boolean.toString(testResult);
            }
        }
        else{
            return "WRONG KEY";
        }
    }
}