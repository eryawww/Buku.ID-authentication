package id.ac.ui.cs.advprog.authentication.services;

import id.ac.ui.cs.advprog.authentication.models.entities.UserEntity;
import id.ac.ui.cs.advprog.authentication.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserEntity> allUsers() {
    List<UserEntity> users = new ArrayList<>();

    userRepository.findAll().forEach(users::add);

    return users;
  }
}