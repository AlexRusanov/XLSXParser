package ua.com.integrity.dto;

import lombok.Data;

@Data
public class ExcelData {

    private String bpCode;
    private String observationArea;
    private String observation;
    private String observationDescription;
    private String rootCause;
    private String riskType;
    private String significance;
    private String riskLevel;
    private String riskCategory;
    private String recommendations;
    private String inspector;
    private String observationRepetitionFeature;
    private Integer lastObservationYear;
    private Integer generalCount;
    private Integer sampleNumber;
    private Integer deviationCount;
    private Double actualLoss;
    private Double potentialLoss;
    private String likelyhood;
    private String financialLoss;
    private String reputational;
    private String regulatory;
    private String businessProcess;
    private String severity;
}
