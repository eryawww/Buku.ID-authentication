package id.ac.ui.cs.advprog.authentication.dtos;

import id.ac.ui.cs.advprog.authentication.models.entities.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
  private String fullName;
  private String email;
  private String phone;
  private String bio;
  private String gender;
  private String role;

  public UserDto() {
  }

  public UserDto(UserEntity userEntity) {
    this.fullName = userEntity.getFullName();
    this.email = userEntity.getEmail();
    this.phone = userEntity.getPhone();
    this.bio = userEntity.getBio();
    this.role = userEntity.getRole();
  }
}
