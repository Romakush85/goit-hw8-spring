package ua.goit.hw8.service.converter;

import org.springframework.stereotype.Service;
import ua.goit.hw8.model.dao.UserDao;
import ua.goit.hw8.model.dto.UserDto;

@Service
public class UserConverter implements Converter<UserDto, UserDao>  {
    @Override
    public UserDto fromDaoToDto(UserDao dao) {
        UserDto dto = new UserDto();
        dto.setId(dao.getId());
        dto.setEmail(dao.getEmail());
        dto.setPassword(dao.getPassword());
        dto.setFirstName(dao.getFirstName());
        dto.setLastName(dao.getLastName());
        dto.setRoles(dao.getRoles());
        return dto;
    }

    @Override
    public UserDao fromDtoToDao(UserDto dto) {
        UserDao dao = new UserDao();
        dao.setId(dto.getId());
        dao.setEmail(dto.getEmail());
        dao.setPassword(dto.getPassword());
        dao.setFirstName(dto.getFirstName());
        dao.setLastName(dto.getLastName());
        dao.setRoles(dto.getRoles());
        return dao;
    }
}
