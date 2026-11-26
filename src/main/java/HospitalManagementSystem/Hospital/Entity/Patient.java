package HospitalManagementSystem.Hospital.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)

    private List<Appointment> appointment=new ArrayList<>();
}
