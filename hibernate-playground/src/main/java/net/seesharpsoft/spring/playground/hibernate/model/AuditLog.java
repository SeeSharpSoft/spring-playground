package net.seesharpsoft.spring.playground.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
public class AuditLog {

    public interface Repository extends JpaRepository<AuditLog, UUID> { }

    public AuditLog() {
        this.time = Instant.now();
    }

    @Id
    @Setter
    @Getter
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Setter
    @Getter
    private Instant time;
}
