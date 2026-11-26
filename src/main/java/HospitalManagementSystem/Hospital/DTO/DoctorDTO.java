package HospitalManagementSystem.Hospital.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private Long id;


    private String name;


    private String specialisation;


    private String email;
}
