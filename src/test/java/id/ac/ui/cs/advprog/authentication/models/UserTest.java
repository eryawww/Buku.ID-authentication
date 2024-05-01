package id.ac.ui.cs.advprog.authentication.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;
import id.ac.ui.cs.advprog.authentication.models.builder.UserBuilder;
import id.ac.ui.cs.advprog.authentication.models.entities.UserEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

public class UserTest {
  UserBuilder userBuilder = new UserBuilder();
  UserEntity user = null;
  String randomUUID = UUID.randomUUID().toString();

  @BeforeEach
  void setUp() {

    user = userBuilder.setFullName("Andi")
        .setEmail("andi@gmail.com")
        .setPhone("081321543876")
        .setPassword("AXASW123ASXASEA")
        .setBio("An assembly competitive programmer")
        .setGender("MALE")
        .build();
    user.setIdUser(randomUUID);
  }

  @Test
  public void testUserFullName() {
    assertEquals("Andi", user.getFullName());
  }

  @Test
  void testUserEmail() {
    assertEquals("andi@gmail.com", user.getEmail());
  }

  @Test
  void testUserPhone() {
    assertEquals("081321543876", user.getPhone());
  }

  @Test
  void testUserPassword() {
    assertEquals("AXASW123ASXASEA", user.getPassword());
  }

  @Test
  void testUserBio() {
    assertEquals("An assembly competitive programmer", user.getBio());
  }

  @Test
  void testUserGender() {
    assertEquals(GenderEnum.MALE.toString(), user.getGender());
  }

  @Test
  void testUserId() {
    assertEquals(randomUUID, user.getIdUser());
  }

  @Test
  void testUserFullNameEmpty() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setFullName("");
    });
  }

  @Test
  void testUserFullNameLessThan3() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setFullName("An");
    });
  }

  @Test
  void testUserEmailEmpty() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setEmail("");
    });
  }

  @Test
  void testUserEmailNotValid() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setEmail("andi");
    });
  }

  @Test
  void testUserPhoneEmpty() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setPhone("");
    });
  }

  @Test
  void testUserPhoneNotValid() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setPhone("081321543");
    });
  }

  @Test
  void testUserPasswordEmpty() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setPassword("");
    });
  }

  @Test
  void testUserPasswordLessThan8() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setPassword("AXASW12");
    });
  }

  @Test
  void testUserGenderInvalid() {
    assertThrows(IllegalArgumentException.class, () -> {
      user.setGender("INVALID");
    });
  }
}
