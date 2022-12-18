package ua.goit.hw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.hw8.model.dao.ProducerDao;

import java.util.UUID;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerDao, UUID> {
}
