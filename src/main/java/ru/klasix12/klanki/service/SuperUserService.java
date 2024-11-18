package ru.klasix12.klanki.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klasix12.klanki.mapper.SuperUserMapper;
import ru.klasix12.klanki.model.SuperUser;
import ru.klasix12.klanki.model.SuperUserDTO;
import ru.klasix12.klanki.repository.SuperUserRepository;

@Service
@RequiredArgsConstructor
public class SuperUserService {
    private final SuperUserRepository superUserRepository;

    public SuperUserDTO create(SuperUser superUser) {
        SuperUser savedSuperUser = superUserRepository.save(superUser);
        return SuperUserMapper.toDto(savedSuperUser);
    }
}
