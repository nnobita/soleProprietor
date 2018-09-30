package com.example.soleProprietor.repository;

import static org.assertj.core.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.soleProprietor.SoleProprietorApplication;
import com.example.soleProprietor.model.Owner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SoleProprietorApplication.class)
@DataJpaTest
@TestPropertySource(
		  locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OwnerRepositoryTest {
    //@Autowired
    //private TestEntityManager entityManager;
 
    @Autowired
    private OwnerRepository ownerRepository;
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
    	Owner james = new Owner();
    	james.setId(1);
    	james.setName("James");
    	james.setStatus(1);
    	james.setUpdatedBy("Administrator");
    	james.setLastUpdate(new Timestamp(System.currentTimeMillis()));
    	
        //entityManager.persist(james);
        //entityManager.flush();
        ownerRepository.save(james);
        // when
        Owner found = ownerRepository.findById(1);
     
        // then
        assertThat(found.getName())
          .isEqualTo(james.getName());
    }
}
