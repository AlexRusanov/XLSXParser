package ua.com.integrity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.integrity.entity.Observation;

@Repository
public interface ObservationRepository extends CrudRepository<Observation, Integer> {
}
