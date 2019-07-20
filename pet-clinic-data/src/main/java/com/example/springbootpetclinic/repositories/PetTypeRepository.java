package com.example.springbootpetclinic.repositories;

import com.example.springbootpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
