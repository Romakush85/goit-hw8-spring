package ua.goit.hw8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.hw8.model.dao.ProductDao;
import ua.goit.hw8.model.dto.ProductDto;
import ua.goit.hw8.repository.ProductRepository;
import ua.goit.hw8.service.converter.ProductConverter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements CrudService<ProductDto> {
    private final ProductRepository repository;
    private final ProductConverter converter;

    @Override
    public ProductDto save(ProductDto dto) {
        if (dto.getId() == null){
            dto.setId(UUID.randomUUID());
        }
        ProductDao dao = repository.save(converter.fromDtoToDao(dto));
        return converter.fromDaoToDto(dao);
    }

    @Override
    public ProductDto findById(UUID id) {
        Optional<ProductDao> optional = repository.findById(id);
        return optional
                .map(converter::fromDaoToDto)
                .orElseGet(() -> {return null;});
    }

    @Override
    public List<ProductDto> findAll() {
        return repository.findAll().stream()
                .map(converter::fromDaoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
