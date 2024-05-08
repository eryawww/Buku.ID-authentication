package id.ac.ui.cs.advprog.authentication.controllers;

import id.ac.ui.cs.advprog.authentication.dtos.UserDto;
import id.ac.ui.cs.advprog.authentication.models.entities.UserEntity;
import id.ac.ui.cs.advprog.authentication.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RequestMapping("/api/user")
@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/me")
  public ResponseEntity<UserDto> authenticatedUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserEntity currentUser = (UserEntity) authentication.getPrincipal();
    UserDto userDto = new UserDto(currentUser);
    return ResponseEntity.ok(userDto);
  }

  @GetMapping("/all")
  public CompletableFuture<ResponseEntity<List<UserDto>>> allUsers() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated()) {
      return CompletableFuture.completedFuture(ResponseEntity.badRequest().build());
    }

    return userService.allUsers()
        .thenApply(users -> {
          List<UserDto> userDtos = users.stream()
              .map(userEntity -> {
                return new UserDto(userEntity);
              })
              .collect(Collectors.toList());
          return ResponseEntity.ok(userDtos);
        })
        .exceptionally(e -> ResponseEntity.badRequest().build());
  }
}