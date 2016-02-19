package pro.krait.hwdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gss on 19.02.2016.
 * User Servlet
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    @ResponseBody                                                   //Указываем, что хотим вернуть именно строку.
    public String getUser(ModelMap model){
        return ("USER");
    }
}
