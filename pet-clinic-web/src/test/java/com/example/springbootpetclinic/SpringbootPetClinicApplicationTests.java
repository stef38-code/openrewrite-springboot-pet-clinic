package com.example.springbootpetclinic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
// have to specify the test class
// @SpringBootTest(classes=SpringbootPetClinicApplication.class)
@SpringBootTest
public class SpringbootPetClinicApplicationTests {

    @Test
    public void contextLoads() {
    }

}
