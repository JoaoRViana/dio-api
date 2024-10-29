package com.example.dio_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dio_api.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsAccount(String accountNumber);
}
