package org.example.service;

import org.example.dto.ChatDto;
import org.example.dto.UserDto;
import org.example.model.Chat;
import org.example.model.User;

public class ModelConverter {
    public ChatDto convertChat(Chat chat){
        return ChatDto.builder()
                .name(chat.getName())
                .maxMembers(chat.getMaxMembers())
                .build();
    }

    public UserDto convertUser(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .build();
    }
}