package ua.goit.hw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.hw8.model.dao.ProductDao;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, UUID> {
}
