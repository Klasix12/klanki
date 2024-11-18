package ru.klasix12.klanki.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperUserDTO {
    private long id;

    private String username;

    private String email;
}
