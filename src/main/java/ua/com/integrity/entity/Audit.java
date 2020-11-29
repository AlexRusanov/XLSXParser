package ua.com.integrity.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "GENERAL_INFORMATION")
public class Audit {

    @Id
    @SequenceGenerator(name = "generalInformationId", sequenceName = "GENERAL_INFORMATION_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generalInformationId")
    @Column(name = "ID")
    private long id;

    @Column(name = "AUDIT_NUMBER")
    private String number;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "INSPECTOR_ORGANIZATION")
    private String inspector_organization;

    @Column(name = "INSPECTED_ORGANIZATION")
    private String inspected_organization;

    @Column(name = "INSPECTION_DATE")
    private LocalDate inspection_date;

    @Column(name = "INSPECTION_PERIOD_START")
    private LocalDate inspection_period_start;

    @Column(name = "INSPECTION_PERIOD_END")
    private LocalDate inspection_period_end;

    @Column(name = "OWNER")
    private String owner;

    public Audit () {
        this.number = "";
    }
}
