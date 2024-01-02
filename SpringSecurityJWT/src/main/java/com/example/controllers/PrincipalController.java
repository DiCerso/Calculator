package com.example.controllers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.controllers.Request.CreateUserDTO;
import com.example.models.RoleEntity;
import com.example.models.UserEntity;
import com.example.models.enums.Erole;
import com.example.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
public class PrincipalController {


    @Autowired
    private PasswordEncoder passwordEncoder;
    //llamo al metodo passwordEncoder que es el encriptador

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/Hello")
    public String hello(){
        return "Hello world not secured";
    }

    @GetMapping("/HelloSecured")
    public String helloSecured(){
        return "Hello world segured";
    }

    @PostMapping("/CreateUser")         //sevalida automaticamente que sean correctos los datos
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createdUser){
        
        Set<RoleEntity> roles = createdUser.getRoles().stream().map(role -> 
                RoleEntity.builder()
                    .name(Erole.valueOf(role))
                    .build())
                    .collect(Collectors.toSet()//si no esta el collect no devuelve los datos del stream
        );//creo las filas de roles segun los que llegan por el body

        UserEntity userEntity = UserEntity.builder()
            .username(createdUser.getUsername())
            .password(passwordEncoder.encode(createdUser.getPassword()))//le mando la password para que la encripte
            .email(createdUser.getEmail())
            .roles(roles)
            .build(); //creo una fila de datos utilizando tambien la cascada para crear user y rol

        userRepository.save(userEntity);//esto sirve para que se guarde en la basede datos


        return ResponseEntity.ok(userEntity);//devuelvo un ok con los datos del user
    }

    

    @DeleteMapping("/DeleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));//elimino el usuario segun el id que llegue por param
        return "Se ah borrado el user con el id ".concat(id); 
    }
}
