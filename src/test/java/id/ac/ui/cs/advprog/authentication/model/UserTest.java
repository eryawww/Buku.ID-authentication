package id.ac.ui.cs.advprog.authentication.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;

import static org.junit.jupiter.api.Assertions.*;

/*
    Focus on the fact that parameter won't change
 */
public class UserTest {
  UserBuilder builder = new UserBuilder();
  User USER1 = null;
  User USER2 = null;

  @BeforeEach
  void setUp() {
    USER1 = builder.setFullname("Andi")
        .setEmail("andi@gmail.com")
        .setPhone("081321543876")
        .setPassword("AXASW123ASXASEA")
        .setBio("An assembly competitive programmer")
        .setGender(GenderEnum.MALE.toString())
        .build();
    USER1.setIdUser(0);

    USER2 = builder.setFullname("Nai")
        .setEmail("nai@gmail.com")
        .setPhone("08123456789")
        .setPassword("ZZXX123OWKX")
        .setBio("A market beater quant")
        .setGender(GenderEnum.FEMALE.toString())
        .build();
    USER2.setIdUser(1);
  }

  @Test
  void testUser1() {
    assertEquals("Andi", USER1.getFullname());
    assertEquals("andi@gmail.com", USER1.getEmail());
    assertEquals("081321543876", USER1.getPhone());
    assertEquals("AXASW123ASXASEA", USER1.getPassword());
    assertEquals("An assembly competitive programmer", USER1.getBio());
    assertEquals(GenderEnum.MALE, USER1.getGender());
  }

  @Test
  void testUser2() {
    assertEquals("Nai", USER2.getFullname());
    assertEquals("nai@gmail.com", USER2.getEmail());
    assertEquals("08123456789", USER2.getPhone());
    assertEquals("ZZXX123OWKX", USER2.getPassword());
    assertEquals("A market beater quant", USER2.getBio());
    assertEquals(GenderEnum.FEMALE, USER2.getGender());
  }

}
