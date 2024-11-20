package ru.klasix12.klanki.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klasix12.klanki.dto.UserDTO;
import ru.klasix12.klanki.mapper.UserMapper;
import ru.klasix12.klanki.model.SuperUser;
import ru.klasix12.klanki.repository.SuperUserRepository;
import ru.klasix12.klanki.repository.UserRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SuperUserRepository superUserRepository;

    public UserDTO save(UserDTO userDTO) {
        SuperUser superUser = superUserRepository.findById(userDTO.getSuperUserId())
                .orElseThrow(() -> new NoSuchElementException("Не удалось найти супер пользователя с id " + userDTO.getSuperUserId()));
        return UserMapper.toDto(userRepository.save(UserMapper.toEntity(userDTO, superUser)));
    }
}
