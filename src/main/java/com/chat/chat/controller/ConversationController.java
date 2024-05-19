package com.chat.chat.controller;

import com.chat.chat.entity.Conversations;
import com.chat.chat.repository.ConversationRepository;
import com.chat.chat.response.ApiResponse;
import com.chat.chat.response.ConversationResponse;
import com.chat.chat.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConversationController {

    @Autowired
    ConversationService conversationService;

    @Autowired
    ConversationRepository conversationRepository;

    @GetMapping("conversation/{userId}")
    public ApiResponse<List<ConversationResponse>> getConversationByIdUser(@PathVariable String userId){
        ApiResponse<List<ConversationResponse>> response = new ApiResponse<>();
        response.setResult(conversationService.getConversationByIdUser(userId));
        return response;
    }

//    @GetMapping("conversation")
//    public List<Conversations> getConversationByIdUser(@PathVariable String userId){
//        return conversationRepository.findByIdw(userId)
//    }

}
