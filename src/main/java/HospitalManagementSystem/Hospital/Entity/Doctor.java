package HospitalManagementSystem.Hospital.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialisation;

    @Column(nullable = false )
    private String email;


    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointment=new ArrayList<>();

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments=new HashSet<>();
}
