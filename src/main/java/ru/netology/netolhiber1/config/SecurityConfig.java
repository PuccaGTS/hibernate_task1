package ru.netology.netolhiber1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Oleg").password(encoder().encode("pass")).roles("READ")
                .and()
                .withUser("Vlad").password(encoder().encode("pass1")).roles("WRITE")
                .and()
                .withUser("Semen").password(encoder().encode("pass2")).roles("DELETE");

    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and()
//                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/persons/by-age").hasAuthority("user")
//                .and()
//                .authorizeRequests().antMatchers("/persons/by-name-surname").hasAuthority("admin")
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//    }
}
