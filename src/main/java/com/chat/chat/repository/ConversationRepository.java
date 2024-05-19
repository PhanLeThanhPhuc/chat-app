package com.chat.chat.repository;

import com.chat.chat.entity.Conversations;
//import com.chat.chat.entity.Users;
import com.chat.chat.response.ConversationResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends MongoRepository<Conversations, String> {

    @Query("{'participants': ?0}")
    List<Conversations> findByParticipantId(Object participantId);

//    @Query("{'id': ?0}")
//    List<Conversations> findByIdw(String participantId);

}
