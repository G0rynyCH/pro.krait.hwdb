package pro.krait.hwdb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by gorynych on 21.02.16.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "fatherName", length = 50)
    private String fatherName;

    @Column(name = "login", nullable = false, length = 20)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    private String passwd;

    @Column(name = "phoneNumber", length = 20)
    private String phoneNumber;

    @Column(name = "email", length = 30)
    private String email;

    public User() {
    }

    public User(String surname, String name, String fatherName, String login, String passwd, String phoneNumber, String email) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.login = login;
        this.passwd = passwd;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.matches("^\\D+$")){                     //Регулярное выражение, проверяющее строку на содержание цифр или не является ли строка пустой
            this.surname = surname;
        } else System.out.println("Некорректно заполнено поле. Фамилия не должна содержать цифры, пробелы или быть пустой");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name.matches("^\\D+$")) this.name = name;
        else System.out.printf("Некорректно заполнено поле. Имя не должно содержать цифры, пробелы или быть пустой");
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {

        if (fatherName.matches("^\\D*$")) this.fatherName = fatherName;
        else System.out.println("Некорректно заполнено поле. Отчество не должно содержать цифры");

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
