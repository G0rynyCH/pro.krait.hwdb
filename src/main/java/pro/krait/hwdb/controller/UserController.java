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
        User user = new User();
        user.setId(1);
        user.setSurname("Gorin");
        user.setName("Sergey");
        user.setFatherName("Stanislavovich");
        user.setLogin("agss");
        user.setPasswd("12345");
        user.setPhoneNumber("5552222");
        user.setEmail("admin@skywell.com.ua");
        return user;
    }
}
