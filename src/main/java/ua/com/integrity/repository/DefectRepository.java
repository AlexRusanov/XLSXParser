package ua.com.integrity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.integrity.entity.Defect;

@Repository
public interface DefectRepository extends CrudRepository<Defect, Integer> {
}
