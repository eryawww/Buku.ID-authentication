package id.ac.ui.cs.advprog.authentication.service;

import id.ac.ui.cs.advprog.authentication.models.entities.UserEntity;
import id.ac.ui.cs.advprog.authentication.repositories.UserRepository;
import id.ac.ui.cs.advprog.authentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testAllUsers() {
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Act
        List<UserEntity> users = userService.allUsers().join();

        // Assert
        assertEquals(2, users.size());
    }

    @Test
    public void testEditUser() {
        UserEntity existingUser = new UserEntity();
        existingUser.setFullName("John Doe");

        UserEntity newUserDetails = new UserEntity();
        newUserDetails.setFullName("Jane Doe");
        newUserDetails.setEmail("jane.doe@example.com");
        newUserDetails.setPassword("securepassword123");
        newUserDetails.setGender("FEMALE");
        newUserDetails.setBio("New bio");
        newUserDetails.setPhone("1234567890");

        when(userRepository.save(any(UserEntity.class))).thenReturn(newUserDetails);

        // Act
        UserEntity updatedUser = userService.editUser(existingUser, newUserDetails);

        // Assert
        verify(userRepository).save(existingUser); // Ensure this is the object being passed
        assertEquals("Jane Doe", updatedUser.getFullName());
        assertEquals("jane.doe@example.com", updatedUser.getEmail());
        assertEquals("securepassword123", updatedUser.getPassword());
        assertEquals("FEMALE", updatedUser.getGender());
        assertEquals("New bio", updatedUser.getBio());
        assertEquals("1234567890", updatedUser.getPhone());
    }

}