package com.lalit.library.userservice.rest;

import com.lalit.library.userservice.model.User;
import com.lalit.library.userservice.respository.UserRepository;
import com.lalit.library.userservice.rest.model.AddUserCommand;
import com.lalit.library.userservice.rest.model.UserResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {

  private static final Logger LOG = getLogger(UserController.class);

  @Autowired private UserRepository userRepository;

    @PostMapping(value = "users",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody AddUserCommand addUserCommand) {
      User user = new User(addUserCommand);
      user = userRepository.save(user);
      String location =
              linkTo(methodOn(UserController.class)
                      .add(addUserCommand)).withSelfRel().getHref() + "/" + user.getUserId();
      return ResponseEntity.created(URI.create(location)).build();
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId) {
        User user = userRepository.getOne(userId);
        UserResponse response = new UserResponse(user);
        return ResponseEntity.ok(response);
    }
}
