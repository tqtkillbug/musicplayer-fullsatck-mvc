package com.tqtplayer.repository;

import com.tqtplayer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ICustomerRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String emailAddress);

}
