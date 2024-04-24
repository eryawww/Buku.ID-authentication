package id.ac.ui.cs.advprog.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.authentication.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
