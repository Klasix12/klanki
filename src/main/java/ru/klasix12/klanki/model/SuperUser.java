package ru.klasix12.klanki.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.klasix12.klanki.validation.groups.OnCreate;
import ru.klasix12.klanki.validation.groups.OnUpdate;

@Entity
@Table(name = "super_users")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SuperUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    @NotNull(groups = OnCreate.class)
    @Email
    private String email;

    @NotNull(groups = OnCreate.class)
    @Size(min = 10, max = 200)
    @Pattern(message = "Неверный формат логина", regexp = "^\\S*$", groups = {OnCreate.class, OnUpdate.class})
    // Непробельные символы
    private String username;

    @NotNull(groups = OnCreate.class)
    @Size(min = 10, max = 200)
    private String password;
}
