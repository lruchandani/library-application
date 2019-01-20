package com.lalit.library.userservice.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lalit.library.userservice.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
  String userId;
  String firstName;
  String lastName;
  Integer age;
  public UserResponse(User user) {
    userId = user.getUserId();
    firstName = user.getFirstName();
    lastName = user.getLastName();
    age = user.getAge();
  }
}
