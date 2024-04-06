package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter

@Entity
@Table(name = "chat")
public class Chat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Integer id;
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "maxMembers")
    private Integer maxMembers;
}