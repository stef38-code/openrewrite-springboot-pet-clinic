package com.example.springbootpetclinic.services;

import com.example.springbootpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
