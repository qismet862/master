package com.example.glmrbackend.User.dao.repo;


import com.example.glmrbackend.User.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByPhoneNumber(String phoneNumber);

}
