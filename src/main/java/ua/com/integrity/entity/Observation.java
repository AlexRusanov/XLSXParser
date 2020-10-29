package ua.com.integrity.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "observations")
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_id")
    private Audit audit;

    @Column(name = "observation_area")
    private String observation_area;

    @Column(name = "content")
    private String content;

    public Observation(Audit audit, String observationArea, String content) {
        this.audit = audit;
        this.observation_area = observationArea;
        this.content = content;
    }
}
