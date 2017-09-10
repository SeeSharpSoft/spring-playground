package net.seesharpsoft.spring.playground.hibernate.controller;

import net.seesharpsoft.spring.playground.hibernate.model.AuditLog;
import net.seesharpsoft.spring.playground.hibernate.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/auditlog")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<AuditLog> getAll() {
        return auditLogService.getAll();
    }
}
