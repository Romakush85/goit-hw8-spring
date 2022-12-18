package ua.goit.hw8.service;

import java.util.List;
import java.util.UUID;

public interface CrudService<T> {
    public T save(T object);
    public T findById(UUID id);
    public List<T> findAll ();
    public void deleteById(UUID id);
}
