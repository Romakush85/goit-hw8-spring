package ua.goit.hw8.service.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.hw8.model.dao.ProducerDao;
import ua.goit.hw8.model.dao.ProductDao;
import ua.goit.hw8.model.dto.ProducerDto;
import ua.goit.hw8.model.dto.ProductDto;
import ua.goit.hw8.repository.ProducerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductConverter implements Converter<ProductDto, ProductDao>{
    private final ProducerConverter converter;
    @Override
    public ProductDto fromDaoToDto(ProductDao dao) {
        ProductDto dto = new ProductDto();
        dto.setId(dao.getId());
        dto.setName(dao.getName());
        dto.setPrice(dao.getPrice());
        dto.setProducerDto(converter.fromDaoToDto(dao.getProducer()));
        return dto;
    }

    @Override
    public ProductDao fromDtoToDao(ProductDto dto) {
        ProductDao dao = new ProductDao();
        dao.setId(dto.getId());
        dao.setName(dto.getName());
        dao.setPrice(dto.getPrice());
        dao.setProducer(converter.fromDtoToDao(dto.getProducerDto()));
        return dao;
    }
}
