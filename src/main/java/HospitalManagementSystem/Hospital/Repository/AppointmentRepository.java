package HospitalManagementSystem.Hospital.Repository;

import HospitalManagementSystem.Hospital.Entity.Appointment;
import org.springframework.data.repository.Repository;

 
import java.util.Optional;

public interface AppointmentRepository extends Repository<Appointment, Long> {

    Optional<Appointment> findById(Long appointmentId);

    Appointment save(Appointment appointment);
}