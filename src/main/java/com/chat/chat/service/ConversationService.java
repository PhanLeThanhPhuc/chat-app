package com.chat.chat.service;

import com.chat.chat.response.ConversationResponse;

import java.util.List;

public interface ConversationService {
    List<ConversationResponse> getConversationByIdUser(String participantId);
}
