package ru.klasix12.klanki.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "super_users")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SuperUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String username;

    private String password;
}
