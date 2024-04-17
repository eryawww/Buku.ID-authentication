package id.ac.ui.cs.advprog.authentication.model;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class User {
  private String fullname;
  private String email;
  private String phone;
  private String password;
  private String bio;
  private String gender;
  private Integer idUser;

  public User(UserBuilder builder) {
    this.fullname = builder.fullname;
    this.email = builder.email;
    this.phone = builder.phone;
    this.password = builder.password;
    this.bio = builder.bio;
    this.gender = builder.gender;
    this.idUser = builder.idUser;
  }
}
