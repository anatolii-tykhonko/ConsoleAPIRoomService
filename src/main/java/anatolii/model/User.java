package anatolii.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    //private List<Room> roomList = new ArrayList<>();

    public User(){}

    public User(Long id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Room> getRoomList() {
//        return roomList;
//    }
//
//    public void setRoomList(List<Room> roomList) {
//        this.roomList = roomList;
//    }

    @Override
    public String toString() {
        return  "Имя: " + name +
                ", фамилия: " + surname +
                ", email: " + email;
    }
}
