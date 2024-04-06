package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ChatDto {
    private final String name;
    private final Integer maxMembers;

    @Override
    public String toString() {
        return "ChatDto{" +
                "name='" + name + '\'' +
                ", maxMembers=" + maxMembers +
                '}';
    }
}
