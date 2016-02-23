package pro.krait.hwdb.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pro.krait.hwdb.entity.User;

/**
 * Created by gss on 19.02.2016.
 * User Servlet
 */
/*
 * Аннотация говорит, что данный класс является контроллером или сервлетом по другой терминологии
 * Так же аннотация сообщает, что все методы данного контроллера будут возвращать JSON объекты
*/
@RestController
@RequestMapping("/users")               //Аннотация говорит, что контроллер будет доступен по указанному адресу
public class UserController {

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    @ResponseBody                                                   //Указываем, что хотим вернуть именно строку.
    public User getUser(){
        return createNewUser();
    }

    private User createNewUser() {
        String surname = "Gorin";
        String name = "Sergey";
        String fatherName = "Stanislavovich";
        String login = "agss";
        String passwd = "12345";
        String phoneNumber = "5552233";
        String email = "S.S.Gorin@gmail.com";
        User user = new User(surname, name, fatherName, login, passwd, phoneNumber, email);

        return user;
    }

    private Boolean verifyString(String str){
        Boolean result = false;
        if (str.matches("^\\w+$")) result = true;
        return result;
    }
}
