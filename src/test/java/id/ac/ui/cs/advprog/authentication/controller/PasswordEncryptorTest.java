package id.ac.ui.cs.advprog.authentication.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.authentication.enums.GenderEnum;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordEncryptorTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testEncryption() {
        String encrypted1 = PasswordEncryptor.encrypt("Hello");
        String expected1 = "185f8db32271fe25f561a6fc938b2e264306ec304eda518007d1764826381969";

        String encrypted2 = PasswordEncryptor.encrypt("123123");
        String expected2 = "96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e";

        assertEquals(encrypted1, expected1);
        assertEquals(encrypted2, expected2);
    }
}
