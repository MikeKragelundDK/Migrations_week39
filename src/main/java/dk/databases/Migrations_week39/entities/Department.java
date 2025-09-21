package dk.databases.Migrations_week39.entities;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "budget")
    private double budget;
    @Column(name = "start_date", columnDefinition = "datetime(6)")
    private LocalDateTime startDate;
    // one to one relationship - nullable.
    @OneToOne
    @JoinColumn(name = "department_head_id",
            foreignKey = @ForeignKey(name = "fk_department_head"),
            nullable = true)
    private Instructor departmentHead;

}