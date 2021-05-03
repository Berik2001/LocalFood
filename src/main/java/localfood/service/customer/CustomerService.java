package localfood.service.customer;


import localfood.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void saveEmployee(Customer customer);
    boolean existsByEmailAndPassword(String email,String password);
  Customer findByEmail(String email);


}
