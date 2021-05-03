package localfood.security;

import localfood.model.Customer;
import localfood.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final CustomerRepository customerRepository;

    public SpringSecurity(@Qualifier("myUserDetailsService") UserDetailsService userDetailsService, CustomerRepository customerRepository) {
        this.userDetailsService = userDetailsService;
        this.customerRepository = customerRepository;
    }


    @Override
    public void configure(HttpSecurity security) throws Exception {

        security
                .csrf().disable()
                .authorizeRequests()
.antMatchers("/burger","/pizza","/beverage","/kfc").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(authenticationSuccessHandler())

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/destroy", "GET"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
    }

    private AuthenticationSuccessHandler authenticationSuccessHandler() {
        return ((request, response, authentication) -> {
            String email = request.getParameter("email");
            Customer customer = customerRepository.findByEmail(email);

            HttpSession session = request.getSession();

            session.setMaxInactiveInterval(60 * 60); //1 hour
            session.setAttribute("customer", customer);

            response.sendRedirect("/");
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return daoAuthenticationProvider;
    }
}
