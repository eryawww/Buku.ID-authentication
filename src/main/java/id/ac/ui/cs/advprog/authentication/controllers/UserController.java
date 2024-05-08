package id.ac.ui.cs.advprog.authentication.controllers;

import id.ac.ui.cs.advprog.authentication.dtos.RegisterUserDto;
import id.ac.ui.cs.advprog.authentication.models.builder.UserBuilder;
import id.ac.ui.cs.advprog.authentication.models.entities.UserEntity;
import id.ac.ui.cs.advprog.authentication.repositories.UserRepository;
import id.ac.ui.cs.advprog.authentication.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {
  private final PasswordEncoder passwordEncoder;
  private final UserService userService;
  private final UserBuilder userBuilder;

  public UserController(UserService userService, PasswordEncoder passwordEncoder) {
    this.userBuilder = new UserBuilder();
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping("/me")
  public ResponseEntity<UserEntity> authenticatedUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    UserEntity currentUser = (UserEntity) authentication.getPrincipal();

    return ResponseEntity.ok(currentUser);
  }

  @PostMapping("/edit")
  public ResponseEntity<UserEntity> editUser(@RequestBody RegisterUserDto input) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    UserEntity currentUser = (UserEntity) authentication.getPrincipal();
    UserEntity newUser = userBuilder.fromRegisterUserDTO(input, passwordEncoder).build();
    currentUser = userService.editUser(currentUser, newUser);

    return ResponseEntity.ok(currentUser);
  }

  @GetMapping("/all")
  public ResponseEntity<List<UserEntity>> allUsers() {
    List<UserEntity> users = userService.allUsers();

    return ResponseEntity.ok(users);
  }
}