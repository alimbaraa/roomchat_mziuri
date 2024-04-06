package org.example.service;

import org.example.dto.ChatDto;
import org.example.model.Chat;

public class ModelConverter {
    public ChatDto convertChat(Chat chat){
        return ChatDto.builder()
                .name(chat.getName())
                .maxMembers(chat.getMaxMembers())
                .build();
    }
}
