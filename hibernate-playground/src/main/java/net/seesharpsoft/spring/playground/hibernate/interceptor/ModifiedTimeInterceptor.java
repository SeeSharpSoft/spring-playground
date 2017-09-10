package net.seesharpsoft.spring.playground.hibernate.interceptor;

import net.seesharpsoft.spring.playground.hibernate.model.AuditLog;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ModifiedTimeInterceptor extends EmptyInterceptor {

    private AuditLog.Repository auditLogRepository;

    @Autowired
    public ModifiedTimeInterceptor(AuditLog.Repository repository) {
        this.auditLogRepository = repository;
    }

    @Override
    public boolean onFlushDirty(Object entity,
                                Serializable id,
                                Object[] currentState,
                                Object[] previousState,
                                String[] propertyNames,
                                Type[] types) {


        return false;
    }

    @Override
    public void afterTransactionBegin(Transaction tx) {
        System.out.println("afterTransactionBegin");
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        System.out.println("afterTransactionCompletion");
    }

    @Override
    public void beforeTransactionCompletion(Transaction tx) {
        System.out.println("beforeTransactionCompletion");

        auditLogRepository.saveAndFlush(new AuditLog());

    }

}
