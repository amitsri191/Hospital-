package HospitalManagementSystem.Hospital;

import HospitalManagementSystem.Hospital.Entity.Appointment;

import HospitalManagementSystem.Hospital.Entity.Insurance;
import HospitalManagementSystem.Hospital.Entity.Patient;
import HospitalManagementSystem.Hospital.Service.AppointmentService;
import HospitalManagementSystem.Hospital.Service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;
    @Test
    public void TestInsurance(){
        Insurance insurance= Insurance.builder()
                .policyNumber("HDFC_1234567")
                .provider("HDFC")
                .validUntil(LocalDate.of(2035,12,10))
                .build();

        Patient patient=insuranceService.assignInsuramceToPatient(insurance,2L);
        System.out.println(patient);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,30))
                .reason("coldfever")
                .build();
        var newAppointment=appointmentService.createNewAppointment(appointment,1L,1L);
        System.out.println(newAppointment);
    }

    @Test
    public void assignAppointment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,30))
                .reason("coldfever")
                .build();
        var newAppointment=appointmentService.createNewAppointment(appointment,1L,1L);
        System.out.println(newAppointment);

        var updatedAppointment=appointmentService.reassignAppointmentToAnother(newAppointment.getId(),3L);
        System.out.println(updatedAppointment);
    }

    @Test
    public void testRemoveInsurance(){
        Patient patient=insuranceService.disassociateInsurance(1L);
        System.out.println(patient);
    }
}
