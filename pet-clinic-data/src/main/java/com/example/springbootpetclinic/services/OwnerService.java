package com.example.springbootpetclinic.services;

import com.example.springbootpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
