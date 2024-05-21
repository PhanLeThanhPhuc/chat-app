package com.chat.chat.service.impl;

import com.chat.chat.entity.Conversations;
import com.chat.chat.entity.GroceryItem;
import com.chat.chat.repository.ConversationRepository;
import com.chat.chat.response.ConversationResponse;
import com.chat.chat.response.GroceryItemResponse;
import com.chat.chat.service.ConversationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConversationServiceImpl implements ConversationService {

    ConversationRepository conversationRepository;

    @Override
    public List<ConversationResponse> getConversationByIdUser(String participantId) {
        ObjectId participantIdObject = new ObjectId(participantId);
        List<Conversations> conversations = conversationRepository.findByParticipantId(participantIdObject);

        List<ConversationResponse> responses = new ArrayList<>();

        for (Conversations item : conversations) {
            ConversationResponse response = new ConversationResponse();
            response.setId(item.getId());
            response.setParticipants(item.getParticipants());
            responses.add(response);
        }
        return responses;
    }
}
