package ua.com.integrity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "OBSERVATIONS")
public class Observation {

    @Id
    @SequenceGenerator(name = "observationsId", sequenceName = "OBSERVATIONS_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "observationsId")
    @Column(name = "ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUDIT_ID")
    private Audit audit;

    @Column(name = "OBSERVATION_AREA")
    private String observation_area;

    @Column(name = "CONTENT")
    private String content;

    public Observation(Audit audit, String observationArea, String content) {
        this.audit = audit;
        this.observation_area = observationArea;
        this.content = content;
    }
}
