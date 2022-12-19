package ua.goit.hw8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.hw8.model.dao.UserDao;
import ua.goit.hw8.model.dto.UserDto;
import ua.goit.hw8.repository.UserRepository;
import ua.goit.hw8.service.converter.UserConverter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements CrudService<UserDto>{
    private final UserConverter converter;
    private final UserRepository repository;

    @Override
    public UserDto save(UserDto dto) {
        if (dto.getId() == null){
            dto.setId(UUID.randomUUID());
        }
        UserDao dao = repository.save(converter.fromDtoToDao(dto));
        return converter.fromDaoToDto(dao);
    }

    @Override
    public UserDto findById(UUID id) {
        Optional<UserDao> optional = repository.findById(id);
        return optional
                .map(converter::fromDaoToDto)
                .orElseGet(() -> {return null;});

    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(converter::fromDaoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public UserDto findByEmail(String email) {
        return converter.fromDaoToDto(repository.findByEmail(email));
    }
}
