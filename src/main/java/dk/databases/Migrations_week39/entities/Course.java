package dk.databases.Migrations_week39.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @Column(name = "credits")
    private int credits;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "instructor_id", foreignKey =  @ForeignKey(name = "fk_course_instructor"), nullable = true)
    private Instructor instructorId;
}
