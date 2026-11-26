package HospitalManagementSystem.Hospital.Service;

import HospitalManagementSystem.Hospital.DTO.DoctorDTO;
import HospitalManagementSystem.Hospital.Entity.Doctor;
import HospitalManagementSystem.Hospital.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors= doctorRepository.findAll();
        return doctors
                .stream()
                .map(doctor1 -> modelMapper.map(doctor1, DoctorDTO.class)).toList();
    }
}
