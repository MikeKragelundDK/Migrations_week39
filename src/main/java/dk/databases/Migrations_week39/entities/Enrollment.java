package dk.databases.Migrations_week39.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private int id;
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "grade")
    private int grade;
}
