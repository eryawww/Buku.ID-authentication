package id.ac.ui.cs.advprog.authentication.model.entity;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "user_app")
@Getter
public class UserEntity {

  @Id
  @Column(name = "id_user", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.UUID)
  private String idUser;

  @Column(name = "full_name", nullable = false, length = 100)
  private String fullName;

  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @Column(name = "phone", nullable = false, length = 17)
  private String phone;

  @Column(name = "password", nullable = false, length = 100)
  private String password;

  @Column(name = "bio")
  private String bio;

  @Column(name = "gender", nullable = false)
  private String gender;

  public UserEntity() {
    this.idUser = UUID.randomUUID().toString();
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public void setFullName(String fullName) throws IllegalArgumentException {
    try {
      checkFullName(fullName);
      this.fullName = fullName;
    } catch (IllegalArgumentException e) {
      throw e;
    }
  }

  public void setEmail(String email) throws IllegalArgumentException {
    try {
      checkEmail(email);
      this.email = email;
    } catch (IllegalArgumentException e) {
      throw e;
    }
  }

  public void setPhone(String phone) throws IllegalArgumentException {
    try {
      checkPhone(phone);
      this.phone = phone;
    } catch (IllegalArgumentException e) {
      throw e;
    }
  }

  public void setPassword(String password) throws IllegalArgumentException {
    try {
      checkPassword(password);
      this.password = password;
    } catch (IllegalArgumentException e) {
      throw e;
    }
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public void setGender(String gender) throws IllegalArgumentException {
    try {
      checkGender(gender);
      this.gender = gender;
    } catch (IllegalArgumentException e) {
      throw e;
    }
  }

  private void checkFullName(String fullName) {
    if (fullName == null || fullName.isEmpty())
      throw new IllegalArgumentException("FullName is Empty");

    if (fullName.length() < 3) {
      throw new IllegalArgumentException("FullName is not valid");
    }
  }

  private void checkEmail(String email) {
    if (email == null || email.isEmpty())
      throw new IllegalArgumentException("Email is Empty");

    if (!email.contains("@"))
      throw new IllegalArgumentException("Email is not valid");

  }

  public void checkPhone(String phone) {
    if (phone == null || phone.isEmpty())
      throw new IllegalArgumentException("Phone is Empty");

    if (phone.length() < 8)
      throw new IllegalArgumentException("Phone is not valid");
  }

  public static void checkPassword(String password) {
    if (password == null || password.isEmpty())
      throw new IllegalArgumentException("Password is Null");

    if (password.length() < 8) {
      throw new IllegalArgumentException("Password is not valid");
    }
  }

  private void checkGender(String gender) {
    if (gender == null || gender.isEmpty())
      throw new IllegalArgumentException("Email is Empty");

    if (!GenderEnum.contains(gender))
      throw new IllegalArgumentException("Gender is not valid");
  }
}
