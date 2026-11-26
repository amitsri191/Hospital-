package HospitalManagementSystem.Hospital.Repository;

import HospitalManagementSystem.Hospital.Entity.Doctor;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends Repository<Doctor, Long> {
    Optional<Doctor> findById(Long doctorId);

    List<Doctor> findAll();
}