package com.test_3_1_1.Spring_boot.repository;

import com.test_3_1_1.Spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
