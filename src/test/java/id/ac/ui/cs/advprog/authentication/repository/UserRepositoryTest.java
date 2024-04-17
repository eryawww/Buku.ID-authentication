package id.ac.ui.cs.advprog.authentication.repository;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;
import id.ac.ui.cs.advprog.authentication.model.User;
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

    User USER1 = new User();
    User USER2 = new User();
    @BeforeEach
    void setUp() {
        USER1.setFullname("Andi");
        USER1.setEmail("andi@gmail.com");
        USER1.setPhone("081321543876");
        //        TODO: SET PASSWORD TO ENCRYPTION
        USER1.setPassword("AXASW123ASXASEA");
        USER1.setBio("An assembly competitive programmer");
        USER1.setGender(GenderEnum.MALE.toString());

        USER2.setFullname("Nai");
        USER2.setEmail("nai@gmail.com");
        USER2.setPhone("08123456789");
        //        TODO: SET PASSWORD TO ENCRYPTION
        USER2.setPassword("ZZXX123OWKX");
        USER2.setBio("A market beater quant");
        USER2.setGender(GenderEnum.FEMALE.toString());
        USER2.setIdUser(1);
    }
    @Test
    void testDuplicateId(){
        userRepository.create(USER1);

        User duplicateUser = new User();
        // Check Null is executed last, so this is fine
        duplicateUser.setIdUser(USER1.getIdUser());
        assertNull(userRepository.create(duplicateUser));
    }

    @Test
    void testInvalidGender(){
        User invalidGenderUser = new User();
        // Check Null is executed last, so this is fine
        invalidGenderUser.setGender("MIAW");

        assertNull(userRepository.create(invalidGenderUser));
    }

    @Test
    void testNullAttribute(){
        User nullAttribute = new User();

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