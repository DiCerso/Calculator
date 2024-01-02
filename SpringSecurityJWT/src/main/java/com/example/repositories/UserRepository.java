package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
    
    //Optional establece que puede venir un UserEntity o un null
    Optional<UserEntity> findByusername(String username);

    //en caso de no usar jpa como arriba se puede hcer  esto usando sintaxsis de JPQL: 
    @Query("select u from UserEntity u where u.username = ?1")
    Optional<UserEntity> getname(String username);

}