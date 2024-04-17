package id.ac.ui.cs.advprog.authentication.model;

public class UserBuilder {
  String fullname;
  String email;
  String phone;
  String password;
  String bio;
  String gender;
  Integer idUser;

  public UserBuilder setFullname(String fullname) {
    this.fullname = fullname;
    return this;
  }

  public UserBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public UserBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public UserBuilder setPassword(String password) {
    this.password = password;
    return this;
  }

  public UserBuilder setBio(String bio) {
    this.bio = bio;
    return this;
  }

  public UserBuilder setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public UserBuilder setIdUser(Integer idUser) {
    this.idUser = idUser;
    return this;
  }

  public User build() {
    User user = new User(this);
    reset();
    return user;
  }

  private void reset() {
    this.fullname = null;
    this.email = null;
    this.phone = null;
    this.password = null;
    this.bio = null;
    this.gender = null;
  }
}
