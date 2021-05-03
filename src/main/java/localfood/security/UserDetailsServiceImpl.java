package localfood.security;

import localfood.model.Customer;
import localfood.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("myUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Autowired
    public UserDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Customer customer = customerRepository.findByEmail(username);
        return getAuthenticatedUser(customer);
    }

    private User getAuthenticatedUser(Customer customer) {
        return new User(
                customer.getEmail(),
                customer.getPassword(),
                true,
                true,
                true,
                true,
                customer.getGrantedAuthorities());
    }
}
