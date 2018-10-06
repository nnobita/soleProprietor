package com.example.soleProprietor.repository;

import static org.assertj.core.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.soleProprietor.model.Owner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private OwnerRepository ownerRepository;
    
    private Owner james;
    private Owner mary;
    
    @Before
    public void setUp() {
    	this.james = insertPerson("James", 0, "Administrator");
    	this.mary = insertPerson("Mary", 1, "Guest");
    }
    
    @After
    public void tearDown() {
    	deletePerson(james);
    	deletePerson(mary);
    }
    
    @Test
    public void whenFindByName_thenReturnOwner() {
        // when
    	List<Owner> found = ownerRepository.findByName("James");
     
        // then
        assertThat(found.size()).isEqualTo(1);
        assertThat(found.get(0).getName())
          .isEqualTo("James");
    }
    
    @Test
    public void whenFindByNameContaining_thenReturnOwner() {
        // when
    	List<Owner> found = ownerRepository.findByNameContaining("a");
     
        // then
        assertThat(found.size()).isEqualTo(2);
    }
    
    @Test
    public void whenFindByNameZ_thenReturnOwner() {
        // when
    	List<Owner> found = ownerRepository.findByName("a");
     
        // then
        assertThat(found.size()).isEqualTo(0);
    }
    
    @Test
    public void whenFindByStatus_thenReturnOwner() {
        // when
        List<Owner> found = ownerRepository.findByStatus(1);
     
        // then
        assertThat(found.size()).isEqualTo(1);
        assertThat(found.get(0).getName())
          .isEqualTo("Mary");
    }
    
    @Test
    public void whenTwoRegistered_thenIdSequencial() {
        // when
    	Owner first = ownerRepository.findByName("James").get(0);
    	Owner second = ownerRepository.findByName("Mary").get(0);
     
        // then
        assertThat(second.getId()).isEqualTo(first.getId() + 1);
    }
    
    private Owner insertPerson(String name, int status, String user) {
        // given
    	Owner owner = new Owner();
    	//owner.setId(1); This causes PresistenceException with entityManager
    	owner.setName(name);
    	owner.setStatus(status);
    	owner.setUpdatedBy(user);
    	owner.setLastUpdate(new Timestamp(System.currentTimeMillis()));
    	
        entityManager.persist(owner);
        entityManager.flush();
        return owner;
    }

    private void deletePerson(Owner owner) {
        entityManager.remove(owner);
        entityManager.flush();
    }
}
