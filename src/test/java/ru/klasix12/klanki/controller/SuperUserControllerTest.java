package ru.klasix12.klanki.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.klasix12.klanki.mapper.SuperUserMapper;
import ru.klasix12.klanki.model.SuperUser;
import ru.klasix12.klanki.service.SuperUserService;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SuperUserController.class)
public class SuperUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SuperUserService superUserService;

    @Test
    void testCreateUser() throws Exception {
        String testUsername = "test_username";
        String testEmail = "test@test.test";
        SuperUser superUser = SuperUser.builder()
                .password("test")
                .username(testUsername)
                .email(testEmail)
                .build();

        when(superUserService.create(any(SuperUser.class))).thenReturn(SuperUserMapper.toDto(superUser));

        mockMvc.perform(post("/api/super-user")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(superUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value(testUsername))
                .andExpect(jsonPath("$.email").value(testEmail));
    }
}
