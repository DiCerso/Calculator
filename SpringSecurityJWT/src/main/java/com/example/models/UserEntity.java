package com.example.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //genera los getters y setters
@AllArgsConstructor//genera el constructor con todos los parametro
@NoArgsConstructor//genera el constructor con ningun parametro
@Builder//implementa 
@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//genera automaticamente el id
    private Long id;
    
    @Email
    @NotBlank
    @Size(max = 80)//no vacio y maximo 80 caracteres
    private String email;
    
    @NotBlank
    @Size(max = 30)
    private String username;
    
    @NotBlank
    private String password;

    //
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))//genera la tabla intermedia entre rol y user
    private Set<RoleEntity> roles;//el set no permite tener elementos duplicados
}
