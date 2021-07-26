package Akgun.HumanResources.DataAccess.Abstracts;

import Akgun.HumanResources.Entities.Concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Data Access Object for User
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String username);
}