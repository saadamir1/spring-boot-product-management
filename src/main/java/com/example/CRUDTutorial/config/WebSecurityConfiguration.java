package com.example.CRUDTutorial.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    // @Autowired
    // private UserDetailsService userDetailsService;

    // @Bean
    // AuthenticationProvider authenticationProvider() {
    //     DaoAuthenticationProvider provider
    //              = new DaoAuthenticationProvider();
    //     provider.setUserDetailsService(userDetailsService);
    //     provider.setPasswordEncoder(new BCryptPasswordEncoder());
    //     return  provider;
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests().anyRequest().permitAll();
    }
}