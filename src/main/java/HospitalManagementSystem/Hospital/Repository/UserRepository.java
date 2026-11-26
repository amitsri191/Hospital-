package HospitalManagementSystem.Hospital.Repository;

import HospitalManagementSystem.Hospital.Entity.Type.AuthProviderType;
import HospitalManagementSystem.Hospital.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByUsername(String username);



   Optional<User> findByProviderIdAndProviderType(String providerId, AuthProviderType providerType);
}
