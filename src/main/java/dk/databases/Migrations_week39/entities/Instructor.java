package dk.databases.Migrations_week39.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "hire_date", columnDefinition = "datetime(6)")
    private LocalDateTime hireDate;
}