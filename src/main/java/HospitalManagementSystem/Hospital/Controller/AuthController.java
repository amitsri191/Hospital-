package HospitalManagementSystem.Hospital.Controller;

import HospitalManagementSystem.Hospital.DTO.LoginRequestDTO;
import HospitalManagementSystem.Hospital.DTO.LoginResponseDTO;
import HospitalManagementSystem.Hospital.DTO.SignupResponseDTO;
import HospitalManagementSystem.Hospital.Security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDTO> signup(@RequestBody LoginRequestDTO signupRequestDTO){
        return ResponseEntity.ok(authService.signup(signupRequestDTO));
    }
}
