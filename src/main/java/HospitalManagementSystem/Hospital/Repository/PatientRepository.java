package HospitalManagementSystem.Hospital.Repository;

import HospitalManagementSystem.Hospital.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
