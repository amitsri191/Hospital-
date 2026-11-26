package HospitalManagementSystem.Hospital.Service;

import HospitalManagementSystem.Hospital.DTO.AddPatientDTO;
import HospitalManagementSystem.Hospital.DTO.PatientDTO;
import HospitalManagementSystem.Hospital.Entity.Patient;
import HospitalManagementSystem.Hospital.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@ToString
public class PatientService {
    private final ModelMapper modelMapper;

    private final PatientRepository patientRepository;
    public List<PatientDTO> getAllPatient() {
        List<Patient> patient = patientRepository.findAll();
        return patient
                .stream().map(patient1 -> modelMapper.map(patient1, PatientDTO.class)).toList();
    }


    public PatientDTO createPatient(AddPatientDTO addPatientDTO) {
        Patient patient =modelMapper.map(addPatientDTO, Patient.class);
        Patient newPatient = patientRepository.save(patient);
        return modelMapper.map(newPatient, PatientDTO.class);
    }

    public Void deletePatient(Long id) {
        if (!patientRepository.existsById(id)){
             throw new IllegalArgumentException("id mot found"+id);
        }else{
            patientRepository.deleteById(id);
        }
        return null;
    }

    public PatientDTO updatePatient(Long id, AddPatientDTO addPatientDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"+id));
        modelMapper.map(addPatientDTO, patient);
        patient = patientRepository.save(patient);
         return modelMapper.map(patient, PatientDTO.class);
    }

    public PatientDTO partialUpdate(Long id, Map<String, Object> updates) {
        Patient patient = patientRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("not found"+id));
        updates.forEach((field,value)->{
            switch (field){
                case "userName":
                    patient.setUserName((String) value);
                    break;
                case "email":
                    patient.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("field is not supported");
            }
        });
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDTO.class);
    }
}
