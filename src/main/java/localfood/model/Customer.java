package localfood.model;


import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@NotBlank(message = "Enter your email")
@Email(message = "Enter a valid email address")
    @Column(name = "email")
    private String email;
@NotBlank(message = "Enter your password")
@Length(min = 6,message = "Password must be at least 6 characters")
    @Column(name = "password")
    private String password;

public Set<GrantedAuthority> getGrantedAuthorities() {
        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER" ));


        return grantedAuthorities;
    }
    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
