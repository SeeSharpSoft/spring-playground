package net.seesharpsoft.spring.playground.hibernate.service;

import net.seesharpsoft.spring.playground.hibernate.model.AuditLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuditLogService {

    @Autowired
    private AuditLog.Repository repository;

    public Collection<AuditLog> getAll() {
        return repository.findAll();
    }

    public AuditLog add(AuditLog auditLog) {
        return repository.saveAndFlush(auditLog);
    }
}
