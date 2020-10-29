package ua.com.integrity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.integrity.entity.Audit;

@Repository
public interface AuditRepository extends CrudRepository<Audit, Integer> {
}
