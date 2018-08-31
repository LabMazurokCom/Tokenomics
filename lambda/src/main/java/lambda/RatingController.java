package lambda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/rating")
public class RatingController {
    @RequestMapping(method = RequestMethod.GET)
    public String checkRating(Map<String, Object> model){
        Map<UUID, User> user = DBUtils.r
        return "registration";
    }
}
