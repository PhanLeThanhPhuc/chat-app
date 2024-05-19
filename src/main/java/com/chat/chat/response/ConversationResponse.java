package com.chat.chat.response;


import lombok.Data;

import java.util.List;

@Data
public class ConversationResponse {
    private String id;
    private List<String> participants;
}
