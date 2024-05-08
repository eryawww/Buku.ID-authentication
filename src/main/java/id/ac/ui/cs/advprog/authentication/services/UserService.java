package id.ac.ui.cs.advprog.authentication.services;

import id.ac.ui.cs.advprog.authentication.models.entities.UserEntity;
import id.ac.ui.cs.advprog.authentication.repositories.UserRepository;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Async("taskExecutorDefault")
  public CompletableFuture<UserEntity> getAuthenticated() {
    return CompletableFuture.supplyAsync(() -> {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      return (UserEntity) authentication.getPrincipal();
    });
  }

  @Async("taskExecutorForHeavyTasks")
  public CompletableFuture<List<UserEntity>> allUsers() {
    return CompletableFuture.supplyAsync(() -> {
      return userRepository.findAll();
    });
  }
}