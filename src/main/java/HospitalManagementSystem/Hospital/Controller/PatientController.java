package HospitalManagementSystem.Hospital.Controller;

import HospitalManagementSystem.Hospital.DTO.AddPatientDTO;
import HospitalManagementSystem.Hospital.DTO.PatientDTO;
import HospitalManagementSystem.Hospital.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class PatientController {


    private final PatientService patientService;



    @GetMapping("/admins")
    public ResponseEntity<List<PatientDTO>> getAllPatient(){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatient());
    }
 @PostMapping("/admin")
    public ResponseEntity<PatientDTO> createStudent(@RequestBody @Valid AddPatientDTO addPatientDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createPatient(addPatientDTO));
 }

 @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(patientService.deletePatient(id));
 }
 @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updateStudent(@PathVariable Long id, @RequestBody AddPatientDTO addPatientDTO){
       return ResponseEntity.status(HttpStatus.FOUND).body(patientService.updatePatient(id, addPatientDTO));
 }

 @PatchMapping("/{id}")
    public ResponseEntity<PatientDTO> partialUpdate(@PathVariable Long id, @RequestBody Map<String,Object> updates) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.partialUpdate(id,updates));
 }
}


