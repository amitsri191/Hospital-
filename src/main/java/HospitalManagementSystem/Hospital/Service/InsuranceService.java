package HospitalManagementSystem.Hospital.Service;

import HospitalManagementSystem.Hospital.Entity.Insurance;
import HospitalManagementSystem.Hospital.Entity.Patient;
import HospitalManagementSystem.Hospital.Repository.InsuranceRepository;
import HospitalManagementSystem.Hospital.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private  final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuramceToPatient(Insurance insurance,Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }
    @Transactional
    public Patient disassociateInsurance(Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);
        return patient;
    }
}
