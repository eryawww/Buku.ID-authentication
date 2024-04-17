package id.ac.ui.cs.advprog.authentication.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;

import static org.junit.jupiter.api.Assertions.*;

/*
    Focus on the fact that parameter won't change
 */
public class UserTest {
  User USER1 = new User();
  User USER2 = new User();

  @BeforeEach
  void setUp() {
    USER1.setFullname("Andi");
    USER1.setEmail("andi@gmail.com");
    USER1.setPhone("081321543876");
    // TODO: SET PASSWORD TO ENCRYPTION
    USER1.setPassword("AXASW123ASXASEA");
    USER1.setBio("An assembly competitive programmer");
    USER1.setGender(GenderEnum.MALE.toString());

    USER2.setFullname("Nai");
    USER2.setEmail("nai@gmail.com");
    USER2.setPhone("08123456789");
    // TODO: SET PASSWORD TO ENCRYPTION
    USER2.setPassword("ZZXX123OWKX");
    USER2.setBio("A market beater quant");
    USER2.setGender(GenderEnum.FEMALE.toString());
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
