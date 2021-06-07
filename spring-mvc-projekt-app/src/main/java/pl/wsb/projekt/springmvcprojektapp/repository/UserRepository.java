package pl.wsb.projekt.springmvcprojektapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.projekt.springmvcprojektapp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

}