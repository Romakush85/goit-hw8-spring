package ua.goit.hw8.service.converter;

import org.springframework.stereotype.Service;
import ua.goit.hw8.model.dao.ProducerDao;
import ua.goit.hw8.model.dto.ProducerDto;

@Service
public class ProducerConverter implements Converter<ProducerDto, ProducerDao>{
    @Override
    public ProducerDto fromDaoToDto(ProducerDao dao) {
        ProducerDto dto = new ProducerDto();
        dto.setId(dao.getId());
        dto.setName(dao.getName());
        return dto;
    }

    @Override
    public ProducerDao fromDtoToDao(ProducerDto dto) {
        ProducerDao dao = new ProducerDao();
        dao.setId(dto.getId());
        dao.setName(dto.getName());
        return dao;
    }
}
