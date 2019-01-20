package com.lalit.library.userservice.model;

import com.lalit.library.userservice.rest.model.AddUserCommand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    String userId;

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    @Column(name = "AGE")
    Integer age;

    public User() {
        userId = UUID.randomUUID().toString();
    }

    public User(AddUserCommand addUserCommand) {
        this();
        firstName = addUserCommand.getFirstName();
        lastName = addUserCommand.getLastName();
        age = addUserCommand.getAge();
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
