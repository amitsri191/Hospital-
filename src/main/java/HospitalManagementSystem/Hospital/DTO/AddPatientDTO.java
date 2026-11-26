package HospitalManagementSystem.Hospital.DTO;

import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddPatientDTO {
    private String userName;
    @Email
    private String email;
}
