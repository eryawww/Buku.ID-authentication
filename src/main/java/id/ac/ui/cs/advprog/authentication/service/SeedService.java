package id.ac.ui.cs.advprog.authentication.service;

import java.util.Locale;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.authentication.model.builder.UserBuilder;
import id.ac.ui.cs.advprog.authentication.model.entity.UserEntity;
import id.ac.ui.cs.advprog.authentication.repository.UserRepository;

@Service
public class SeedService {
  @Autowired
  private UserRepository userRepository;
  private final UserBuilder userBuilder = new UserBuilder();
  private final String[] GENDER = { "MALE", "FEMALE", "OTHER" };
  private static final int NUMBER_OF_USER = 20;

  public void seed() {
    @SuppressWarnings("deprecation")
    Faker faker = new Faker(new Locale("id_ID"));

    for (int i = 0; i < NUMBER_OF_USER; i++) {
      String fullName = faker.name().fullName();
      String email = faker.internet().emailAddress();
      String phone = faker.phoneNumber().phoneNumber();
      String password = faker.internet().password();
      String bio = faker.lorem().sentence();
      String gender = GENDER[faker.random().nextInt(0, 2)];

      UserEntity user = userBuilder
          .setFullName(fullName)
          .setEmail(email)
          .setPhone(phone)
          .setPassword(password)
          .setBio(bio)
          .setGender(gender)
          .build();
      userRepository.save(user);
    }
  }
}
