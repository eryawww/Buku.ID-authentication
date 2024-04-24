package id.ac.ui.cs.advprog.authentication.model.entity;

import java.util.UUID;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;
import lombok.Getter;

@Getter
public class UserEntity {
  private String fullName;
  private String email;
  private String phone;
  private String password;
  private String bio;
  private String gender;
  private String idUser;

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

  private void checkFullName(String fullname) {
    if (fullname == null || fullname.isEmpty())
      throw new IllegalArgumentException("FullName is Empty");

    if (fullname.length() < 3) {
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

    if (phone.length() < 10)
      throw new IllegalArgumentException("Phone is not valid");

    if (!phone.matches("[0-9]+"))
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
