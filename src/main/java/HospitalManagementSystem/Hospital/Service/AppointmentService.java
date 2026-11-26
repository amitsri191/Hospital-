package HospitalManagementSystem.Hospital.Service;

import HospitalManagementSystem.Hospital.Entity.Appointment;
import HospitalManagementSystem.Hospital.Entity.Doctor;
import HospitalManagementSystem.Hospital.Entity.Patient;
import HospitalManagementSystem.Hospital.Repository.AppointmentRepository;
import HospitalManagementSystem.Hospital.Repository.DoctorRepository;
import HospitalManagementSystem.Hospital.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId()!=null) throw new IllegalArgumentException("appointment should not have");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointment().add(appointment);
//        doctor.getAppointment().add(appointment);

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reassignAppointmentToAnother(Long appointmentId, Long doctorId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        appointment.setDoctor(doctor);
        doctor.getAppointment().add(appointment);
        return appointmentRepository.save(appointment);
    }
}
