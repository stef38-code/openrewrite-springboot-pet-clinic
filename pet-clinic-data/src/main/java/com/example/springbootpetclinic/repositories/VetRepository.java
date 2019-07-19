package com.example.springbootpetclinic.repositories;

import com.example.springbootpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
