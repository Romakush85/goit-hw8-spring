package ua.goit.hw8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.hw8.model.dao.ProducerDao;
import ua.goit.hw8.model.dto.ProducerDto;
import ua.goit.hw8.repository.ProducerRepository;
import ua.goit.hw8.service.converter.ProducerConverter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerService implements CrudService<ProducerDto>{
    private final   ProducerConverter converter;
    private final ProducerRepository repository;

    @Override
    public ProducerDto save(ProducerDto dto) {
        if (dto.getId() == null){
            dto.setId(UUID.randomUUID());
        }
        ProducerDao dao = repository.save(converter.fromDtoToDao(dto));
        return converter.fromDaoToDto(dao);
    }


    @Override
    public ProducerDto findById(UUID id) {
        Optional<ProducerDao> optional = repository.findById(id);
        return optional
                .map(converter::fromDaoToDto)
                .orElseGet(() -> {return null;});
    }

    @Override
    public List<ProducerDto> findAll() {
        return repository.findAll().stream()
                .map(converter::fromDaoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
