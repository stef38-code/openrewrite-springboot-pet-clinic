package com.example.springbootpetclinic.bootstrap;

import com.example.springbootpetclinic.model.*;
import com.example.springbootpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final OwnerService ownerService;
    private final VetService vetService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner mike = new Owner();
        mike.setFirstName("Michael");
        mike.setLastName("Weston");
        mike.setAddress("123 Brick St");
        mike.setCity("Miami");
        mike.setTelephone("123456789");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(mike);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        ownerService.save(mike);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        fiona.setAddress("123 Brick St");
        fiona.setCity("Miami");
        fiona.setTelephone("234567891");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(fiona);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        fiona.getPets().add(fionasCat);

        ownerService.save(fiona);

        System.out.println("Loaded Owners....");

        Visit fionasCatVisit = new Visit();
        fionasCatVisit.setPet(fionasCat);
        fionasCatVisit.setDate(LocalDate.now());
        fionasCatVisit.setDescription("Sneezy Kitty");

        visitService.save(fionasCatVisit);

        System.out.println("Loaded Visits....");

        Vet sam = new Vet();
        sam.setFirstName("Sam");
        sam.setLastName("Axe");
        sam.getSpecialities().add(savedRadiology);

        vetService.save(sam);

        Vet jessie = new Vet();
        jessie.setFirstName("Jessie");
        jessie.setLastName("Porter");
        jessie.getSpecialities().add(savedSurgery);

        vetService.save(jessie);

        System.out.println("Loaded Vets....");
    }

}
