package pl.wsb.projekt.springmvcprojektapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.projekt.springmvcprojektapp.model.Role;
import pl.wsb.projekt.springmvcprojektapp.model.enums.ERole;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
