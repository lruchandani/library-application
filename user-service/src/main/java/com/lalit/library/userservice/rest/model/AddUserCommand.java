package com.lalit.library.userservice.rest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserCommand {
    String firstName;
    String lastName ;
    int age;
}
