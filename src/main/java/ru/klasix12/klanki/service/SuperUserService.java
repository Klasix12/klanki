package ru.klasix12.klanki.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.klasix12.klanki.dto.SuperUserDTO;
import ru.klasix12.klanki.mapper.SuperUserMapper;
import ru.klasix12.klanki.model.SuperUser;
import ru.klasix12.klanki.model.User;
import ru.klasix12.klanki.repository.SuperUserRepository;
import ru.klasix12.klanki.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SuperUserService {
    private final SuperUserRepository superUserRepository;
    private final UserRepository userRepository;

    public SuperUserDTO create(SuperUser superUser) {
        SuperUser savedSuperUser = superUserRepository.save(superUser);
        return SuperUserMapper.toDto(savedSuperUser);
    }

    @Transactional
    public SuperUserDTO update(SuperUser newSuperUser) {
        SuperUser superUser = superUserRepository.findById(newSuperUser.getId())
                .orElseThrow(() -> new NoSuchElementException("Не удалось найти пользователя с id " + newSuperUser.getId()));
        return SuperUserMapper.toDto(superUserRepository.save(SuperUser.builder()
                .id(newSuperUser.getId() == null ? superUser.getId() : newSuperUser.getId())
                .email(newSuperUser.getEmail() == null ? superUser.getEmail() : newSuperUser.getEmail())
                .username(newSuperUser.getUsername() == null ? superUser.getUsername() : newSuperUser.getUsername())
                .build()));
    }

    public List<User> findUsersBySuperUserId(long id) {
        return userRepository.findAllBySuperUserId(id);
    }
}
