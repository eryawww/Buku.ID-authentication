package id.ac.ui.cs.advprog.authentication.repository;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;
import id.ac.ui.cs.advprog.authentication.model.User;
import id.ac.ui.cs.advprog.authentication.model.UserBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/*
    Focus on the fact that parameter won't change
 */
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

  @InjectMocks
  UserRepository userRepository;

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
  void testDuplicateId() {
    userRepository.create(USER1);

    User duplicateUser = builder.build();
    // Check Null is executed last, so this is fine
    duplicateUser.setIdUser(USER1.getIdUser());
    assertNull(userRepository.create(duplicateUser));
  }

  @Test
  void testInvalidGender() {
    User invalidGenderUser = builder.build();
    // Check Null is executed last, so this is fine
    invalidGenderUser.setGender("MIAW");

    assertNull(userRepository.create(invalidGenderUser));
  }

  @Test
  void testNullAttribute() {
    User nullAttribute = builder.build();

    assertNull(userRepository.create(nullAttribute));

    nullAttribute.setFullname("restu");
    assertNull(userRepository.create(nullAttribute));

    nullAttribute.setEmail("restugeming@gmail.com");
    assertNull(userRepository.create(nullAttribute));

    nullAttribute.setPhone("696969696969");
    assertNull(userRepository.create(nullAttribute));

    nullAttribute.setPassword("restu123");
    assertNull(userRepository.create(nullAttribute));

    nullAttribute.setBio("ADPRO? HARUS A");
    assertNull(userRepository.create(nullAttribute));

    nullAttribute.setGender(GenderEnum.FEMALE.toString());
    // Since idUser is automatically set, everything is set
    assertNotNull(userRepository.create(nullAttribute));

    nullAttribute.setIdUser(5012);
    assertNotNull(userRepository.create(nullAttribute));
  }
}