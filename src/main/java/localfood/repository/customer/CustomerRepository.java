package localfood.repository.customer;


import localfood.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmailAndPassword(String email,String password);
    Customer findByEmail(String email);
}
