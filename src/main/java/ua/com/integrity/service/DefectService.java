package ua.com.integrity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.integrity.entity.Defect;
import ua.com.integrity.repository.DefectRepository;

import java.util.List;

@Service
public class DefectService {

    @Autowired
    private DefectRepository defectRepository;

    public void create(Defect defect){
        defectRepository.save(defect);
    }

    public void createAllForObservation(List<Defect> defects){
        defectRepository.saveAll(defects);
    }
}
