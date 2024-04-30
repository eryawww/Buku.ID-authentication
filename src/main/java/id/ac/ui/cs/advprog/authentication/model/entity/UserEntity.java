package id.ac.ui.cs.advprog.authentication.model.entity;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;
import id.ac.ui.cs.advprog.authentication.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

@Entity
@Table(name = "users")
@Getter
public class UserEntity {

  @Id
  @Setter
  @Column(name = "id_user", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.UUID)
  private String idUser;

  @Column(name = "full_name", nullable = false, length = 100)
  private String fullName;

  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @Column(name = "phone", nullable = false, length = 16)
  private String phone;

  @Column(name = "password", nullable = false, length = 100)
  private String password;

  @Setter
  @Column(name = "bio")
  private String bio;

  @Column(name = "gender", nullable = false)
  private String gender;

  @Column(name = "role", nullable = false)
  private String role;

  public void setFullName(String fullName) throws IllegalArgumentException {
    if (fullName == null || fullName.isEmpty()) {
      throw new IllegalArgumentException("FullName is Empty");
    }

    if (fullName.length() < 3) {
      throw new IllegalArgumentException("FullName is not valid");
    }

    this.fullName = fullName;
  }

  public void setEmail(String email) throws IllegalArgumentException {
    if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Email is Empty");
    }

    if (!Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,7}\\b").matcher(email).matches()) {
      throw new IllegalArgumentException("Email is not valid");
    }

    this.email = email;
  }

  public void setPhone(String phone) throws IllegalArgumentException {
    if (phone == null || phone.isEmpty()) {
      throw new IllegalArgumentException("Phone is Empty");
    }

    if (phone.length() < 10 || phone.length() > 16){
      throw new IllegalArgumentException("Phone is not valid");
    }

    phone.replaceAll("[^\\d]", "");
    this.phone = phone;
  }

  public void setPassword(String password) throws IllegalArgumentException {
    if (password == null) {
      throw new IllegalArgumentException("Password is Null");
    }

    if (password.length() < 8) {
      throw new IllegalArgumentException("Password is not valid");
    }

    this.password = password;
  }

  public void setGender(String gender) throws IllegalArgumentException {
    if (gender == null) {
      throw new IllegalArgumentException("Gender is Empty");
    }

    if (!GenderEnum.contains(gender)) {
      throw new IllegalArgumentException("Gender is not valid");
    }

    this.gender = gender;
  }

  public void setRole(String role) throws IllegalArgumentException {

    if (role == null) {
      throw new IllegalArgumentException("Role is Empty");
    }

    if (!RoleEnum.contains(role)) {
      throw new IllegalArgumentException("Role is not valid");
    }

    this.role = role;
  }
}
