package net.dmitrycost.springboot.SpringBoot.repository;

import net.dmitrycost.springboot.SpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
