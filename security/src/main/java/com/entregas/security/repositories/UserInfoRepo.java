package com.entregas.security.repositories;

import com.entregas.security.entities.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoEntity, Long> {
    Optional<UserInfoEntity> findByEmailId(String emailId);

}
