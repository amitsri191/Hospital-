package HospitalManagementSystem.Hospital.Controller;

import HospitalManagementSystem.Hospital.DTO.DoctorDTO;
import HospitalManagementSystem.Hospital.Entity.Doctor;
import HospitalManagementSystem.Hospital.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class DoctorController {
    private  final DoctorService doctorService;
    @GetMapping("/doctor")
    public ResponseEntity<List<DoctorDTO>> getAllDoctor(){
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getAllDoctors());
    }
}
