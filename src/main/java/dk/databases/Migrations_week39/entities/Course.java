package dk.databases.Migrations_week39.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private int id;
    @Column(name = "title")
    private String title;

    // Update for 7, change to double.
    @Column(name = "credits", precision = 5, scale = 2)
    private BigDecimal credits;
}
