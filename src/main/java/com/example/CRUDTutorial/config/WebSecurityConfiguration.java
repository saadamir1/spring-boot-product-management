package com.example.CRUDTutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    //@Value("${security.disabled}")
    //private boolean securityDisabled;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                 = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        if (securityDisabled) {  //this disabling security used specifically for the testing purpose
//            http.csrf().disable()
//                    .authorizeRequests().anyRequest().permitAll();
//        } else {
            http.exceptionHandling()
                    .accessDeniedHandler((request, response, accessDeniedException) -> {
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        response.getWriter().write("Access Denied: You do not have permission to access this resource.");
                    })
                    .and()
                    .authorizeRequests()
                    .antMatchers("/", "/logout").permitAll()
                    .antMatchers("/products/").hasAnyAuthority("user", "admin")
                    .antMatchers("/products/**").hasAuthority("admin")
                    .antMatchers("/customers/**").hasAuthority("admin")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .logout().permitAll()
                    .and()
                    .httpBasic().disable();
        }
//    }
}
