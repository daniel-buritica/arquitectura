package co.com.umb.crowdfunding.arquitectura.infrastructure.driveradapter.customerpostgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Boolean existsCustomerByEmail(String email);

}
