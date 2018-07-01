package com.andrews.tst.repository;

import com.andrews.tst.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    List<User> findUserByNomeContainsIgnoreCase(String name);
}