package HospitalManagementSystem.Hospital.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class Appointment {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private LocalDateTime appointmentTime;

   @Column(nullable = false,length = 50)
   private String reason;

   @ManyToOne
   @JoinColumn(name = "patient_appointment_id",nullable = false)
   private Patient patient;

   @ManyToOne
   @JoinColumn(nullable = false)
   private Doctor doctor;
}
