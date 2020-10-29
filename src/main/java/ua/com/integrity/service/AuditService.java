package ua.com.integrity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.integrity.entity.Audit;
import ua.com.integrity.repository.AuditRepository;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public Audit create(Audit audit){
        return auditRepository.save(audit);
    }
}
