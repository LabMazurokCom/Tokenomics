package lambda;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
@Controller
@RequestMapping("/registration")
public class RegisterController {
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model){
        model.put("name", new StringWrapper());
        return "registration";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String regUser(@Valid @ModelAttribute("name") StringWrapper name, Map<String, Object> model){
        User user = new User(name.getName());
        DBUtils.userRegistration(user);
        model.put("key", user.getKey());
        return "successRegistration";
    }
}
