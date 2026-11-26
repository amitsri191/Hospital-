package HospitalManagementSystem.Hospital;

import HospitalManagementSystem.Hospital.DTO.AddPatientDTO;
import HospitalManagementSystem.Hospital.DTO.PatientDTO;
import HospitalManagementSystem.Hospital.Entity.Patient;
import HospitalManagementSystem.Hospital.Repository.PatientRepository;
import HospitalManagementSystem.Hospital.Service.PatientService;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@ToString
public class PatientTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
    @Test
    public void addpatient(){
        AddPatientDTO addPatientDTO= AddPatientDTO.builder()
                .userName("atul")
                .email("atul@gmail.com")
                .build();
        PatientDTO patientDTO=patientService.createPatient(addPatientDTO);
        System.out.println(patientDTO);
    }

    @Test
    public void getAllAppointment(){
        List<Patient> patientList=patientRepository.findAll();
        System.out.println(patientList);
    }
}
