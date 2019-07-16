package com.example.springbootpetclinic.services.map;

import com.example.springbootpetclinic.model.Speciality;
import com.example.springbootpetclinic.model.Vet;
import com.example.springbootpetclinic.services.SpecialityService;
import com.example.springbootpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object == null)
            return null;

        // vet object not null
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                // new Speciality
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
