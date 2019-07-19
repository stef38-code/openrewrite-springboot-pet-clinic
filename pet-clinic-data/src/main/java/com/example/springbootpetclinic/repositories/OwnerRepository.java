package com.example.springbootpetclinic.repositories;

import com.example.springbootpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
