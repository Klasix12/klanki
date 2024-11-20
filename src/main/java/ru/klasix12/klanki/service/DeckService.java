package ru.klasix12.klanki.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klasix12.klanki.dto.DeckDTO;
import ru.klasix12.klanki.mapper.DeckMapper;
import ru.klasix12.klanki.model.User;
import ru.klasix12.klanki.repository.DeckRepository;
import ru.klasix12.klanki.repository.UserRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DeckService {
    private final DeckRepository deckRepository;
    private final UserRepository userRepository;

    public DeckDTO save(DeckDTO deckDTO) {
        User user = userRepository.findById(deckDTO.getUserId())
                .orElseThrow(() -> new NoSuchElementException("Не удалось найти пользователя с id " + deckDTO.getUserId()));
        return DeckMapper.toDto(deckRepository.save(DeckMapper.toEntity(deckDTO, user)));
    }
}
