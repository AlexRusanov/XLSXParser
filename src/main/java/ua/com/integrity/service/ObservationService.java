package ua.com.integrity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.integrity.entity.Observation;
import ua.com.integrity.repository.ObservationRepository;

@Service
public class ObservationService {

    @Autowired
    private ObservationRepository observationRepository;

    public Observation create(Observation observation){
        return observationRepository.save(observation);
    }
}
