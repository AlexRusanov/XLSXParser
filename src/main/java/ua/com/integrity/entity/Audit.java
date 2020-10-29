package ua.com.integrity.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "general_information")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "inspector_organization")
    private String inspector_organization;

    @Column(name = "inspected_organization")
    private String inspected_organization;

    @Column(name = "inspection_date")
    private LocalDate inspection_date;

    @Column(name = "inspection_period_start")
    private LocalDate inspection_period_start;

    @Column(name = "inspection_period_end")
    private LocalDate inspection_period_end;

    @Column(name = "owner")
    private String owner;
}
