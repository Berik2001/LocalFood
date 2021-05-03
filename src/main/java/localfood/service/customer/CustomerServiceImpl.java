package localfood.service.customer;



import localfood.model.Customer;
import localfood.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public List <Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveEmployee(Customer customer) {
customerRepository.save(customer);
    }

    @Override
    public boolean existsByEmailAndPassword(String email,String password) {
        return customerRepository.existsByEmailAndPassword(email,password);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email) ;
    }


}
