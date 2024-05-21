package com.chat.chat.repository;

import com.chat.chat.entity.Conversations;
import com.chat.chat.entity.Users;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {

    boolean existsByEmail(String email);
    Optional<Users> findByUsername(String username);

}
