package com.example.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // no entiendo porque pide el throws Exception
        return httpSecurity
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/Hello").permitAll();
                auth.anyRequest().authenticated();
            })
            .sessionManagement(sesion -> {
                sesion.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            })
            .httpBasic()
            .and()
            .build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("santiago")
                            .password("1234")
                            .roles()
                            .build());

        //se crea un usuario en memoria para la seguridad
        return manager;
                
    }

    //establece la forma de encriptar
    @Bean
    PasswordEncoder passwordEncoder(){
        //esto sirve para probar primero si funciona todo sin encriptar
        /* return NoOpPasswordEncoder.getInstance(); */

        //BCryptPasswordEncoder es un algoritmo de encriptacion 
        return new BCryptPasswordEncoder();
    }


    
    //para que se pueda utilizar el usuario de userDetailsService se necesita un objeto que administre la autenticacion
    //authenticationManager exije utilizar la contraseña encriptada
    //este metodo utiliza el usuario creado anteriormente y la encriptacion de passwordEncoder
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailsService())
            .passwordEncoder(passwordEncoder)
            .and()
            .build();
    }
}
