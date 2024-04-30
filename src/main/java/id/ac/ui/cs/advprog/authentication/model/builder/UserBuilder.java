package id.ac.ui.cs.advprog.authentication.model.builder;

import java.security.InvalidParameterException;

import id.ac.ui.cs.advprog.authentication.model.entity.UserEntity;
import lombok.Getter;

@Getter
public class UserBuilder {
  UserEntity currentUser = new UserEntity();

  public UserBuilder setFullName(String fullName) {
    currentUser.setFullName(fullName);
    return this;
  }

  public UserBuilder setEmail(String email) {
    currentUser.setEmail(email);
    return this;
  }

  public UserBuilder setPhone(String phone) {
    currentUser.setPhone(phone);
    return this;
  }

  public UserBuilder setPassword(String password) {
    currentUser.setPassword(password);
    return this;
  }

  public UserBuilder setBio(String bio) {
    currentUser.setBio(bio);
    return this;
  }

  public UserBuilder setGender(String gender) {
    currentUser.setGender(gender.toUpperCase());
    return this;
  }

  public UserBuilder setRole(String role) {
    currentUser.setRole(role.toUpperCase());
    return this;
  }

  public UserEntity build() throws InvalidParameterException {
    UserEntity finalUser = currentUser;
    reset();
    return finalUser;
  }

  private void reset() {
    currentUser = new UserEntity();
  }
}
