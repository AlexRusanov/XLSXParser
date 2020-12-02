package ua.com.integrity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DEFECTS")
public class Defect {

    @Id
    @SequenceGenerator(name = "defectsId", sequenceName = "DEFECTS_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "defectsId")
    @Column(name = "ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OBSERVATION_ID")
    private Observation observation;

    @Column(name = "DP_KOD")
    private String dp_kod;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ROOT_CAUSE")
    private String root_cause;

    @Column(name = "RISK_TYPE_DAD")
    private String risk_type_dad;

    @Column(name = "RISK_CATEGORY_DAD")
    private String risk_category_dad;

    @Column(name = "RISK_LEVEL_DAD")
    private String risk_level_dad;

    @Column(name = "RISK_TYPE_RID")
    private String risk_type_rid;

    @Column(name = "RISK_CATEGORY_RID")
    private String risk_category_rid;

    @Column(name = "RISK_LEVEL_RID")
    private String risk_level_rid;

    @Column(name = "RECOMMENDATION_DAD")
    private String recommendation_dad;

    @Column(name = "INSPECTOR")
    private String inspector;

    @Column(name = "REPETITION_FEATURE")
    private String repetition_feature;

    @Column(name = "DEFECT_YEAR")
    private Integer defect_year;

    @Column(name = "GENERAL_COUNT")
    private Integer general_count;

    @Column(name = "SAMPLE_NUMBER")
    private Integer sample_number;

    @Column(name = "DEFECT_COUNT")
    private Integer defect_count;

    @Column(name = "ACTUAL_LOSS")
    private Double actual_loss;

    @Column(name = "POTENTIAL_LOSS")
    private Double potential_loss;

    @Column(name = "REPUTATIONAL")
    private String reputational;

    @Column(name = "REGULATORY")
    private String regulatory;

    @Column(name = "BUSINESS_PROCESS")
    private String business_process;

    @Column(name = "SEVERITY")
    private String severity;

    @Column(name = "RISK_SET_BOOL_STR")
    private String risk_set;

    @Column(name = "PMO_RESPONSE_MEASURE")
    private String pmo_response_measure;

    @Column(name = "PMO_COMMENT")
    private String pmo_comment;

    @Column(name = "PMO_SET_BOOL_STR")
    private String pmo_set;

    @Column(name = "TASK_SET_BOOL_STR")
    private String task_set;

    @Column(name = "SIGNIFICANCE")
    private String significance;

    @Column(name = "LIKELYHOOD")
    private String likelyhood;

    @Column(name = "FINANTIAL_LOSS")
    private String finantial_loss;

    public Defect(Observation observation, String bpCode, String observationDescription, String rootCause, String riskType, String riskCategory, String riskLevel, String recommendations, String inspector, String observationRepetitionFeature, Integer lastObservationYear, Integer generalCount, Integer sampleNumber, Integer deviationCount, Double actualLoss, Double potentialLoss, String reputational, String regulatory, String businessProcess, String severity, String significance, String likelyhood, String finantialLoss) {
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
        this.risk_set = "false";
        this.pmo_set = "false";
        this.task_set = "false";
        this.significance = significance;
        this.likelyhood = likelyhood;
        this.finantial_loss = finantialLoss;
    }
}
