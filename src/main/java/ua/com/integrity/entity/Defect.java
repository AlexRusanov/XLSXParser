package ua.com.integrity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "defects")
public class Defect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "observation_id")
    private Observation observation;

    @Column(name = "dp_kod")
    private String dp_kod;

    @Column(name = "description")
    private String description;

    @Column(name = "root_cause")
    private String root_cause;

    @Column(name = "risk_type_dad")
    private String risk_type_dad;

    @Column(name = "risk_category_dad")
    private String risk_category_dad;

    @Column(name = "risk_level_dad")
    private String risk_level_dad;

    @Column(name = "risk_type_rid")
    private String risk_type_rid;

    @Column(name = "risk_category_rid")
    private String risk_category_rid;

    @Column(name = "risk_level_rid")
    private String risk_level_rid;

    @Column(name = "recommendation_dad")
    private String recommendation_dad;

    @Column(name = "inspector")
    private String inspector;

    @Column(name = "repetition_feature")
    private String repetition_feature;

    @Column(name = "defect_year")
    private Integer defect_year;

    @Column(name = "general_count")
    private Integer general_count;

    @Column(name = "sample_number")
    private Integer sample_number;

    @Column(name = "defect_count")
    private Integer defect_count;

    @Column(name = "actual_loss")
    private Double actual_loss;

    @Column(name = "potential_loss")
    private Double potential_loss;

    @Column(name = "reputational")
    private String reputational;

    @Column(name = "regulatory")
    private String regulatory;

    @Column(name = "business_process")
    private String business_process;

    @Column(name = "severity")
    private String severity;

    @Column(name = "risk_set")
    private Boolean risk_set;

    @Column(name = "pmo_response_measure")
    private String pmo_response_measure;

    @Column(name = "pmo_comment")
    private String pmo_comment;

    @Column(name = "pmo_set")
    private Boolean pmo_set;

    @Column(name = "task_set")
    private Boolean task_set;

    @Column(name = "significance")
    private String significance;

    public Defect(Observation observation, String bpCode, String observationDescription, String rootCause, String riskType, String riskCategory, String riskLevel, String recommendations, String inspector, String observationRepetitionFeature, Integer lastObservationYear, Integer generalCount, Integer sampleNumber, Integer deviationCount, Double actualLoss, Double potentialLoss, String reputational, String regulatory, String businessProcess, String severity) {
        this.observation = observation;
        this.dp_kod = bpCode;
        this.description = observationDescription;
        this.root_cause = rootCause;
        this.risk_type_dad = riskType;
        this.risk_category_dad = riskCategory;
        this.risk_level_dad = riskLevel;
        this.recommendation_dad = recommendations;
        this.inspector = inspector;
        this.repetition_feature = observationRepetitionFeature;
        this.defect_year = lastObservationYear;
        this.general_count = generalCount;
        this.sample_number = sampleNumber;
        this.defect_count = deviationCount;
        this.actual_loss = actualLoss;
        this.potential_loss = potentialLoss;
        this.reputational = reputational;
        this.regulatory = regulatory;
        this.business_process = businessProcess;
        this.severity = severity;
        this.risk_set = false;
        this.pmo_set = false;
        this.task_set = false;
    }
}
