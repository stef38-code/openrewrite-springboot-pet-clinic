package springbootpetclinic;

import com.example.springbootpetclinic.SpringbootPetClinicApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// have to specify the test class
@SpringBootTest(classes=SpringbootPetClinicApplication.class)
public class SpringbootPetClinicApplicationTests {

    @Test
    public void contextLoads() {
    }

}
