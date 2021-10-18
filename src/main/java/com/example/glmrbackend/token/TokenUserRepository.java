package com.example.glmrbackend.token;

import com.example.glmrbackend.token.TokenUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenUserRepository extends JpaRepository<TokenUser,String> {
}
