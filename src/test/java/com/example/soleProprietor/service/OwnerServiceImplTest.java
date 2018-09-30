package com.example.soleProprietor.service;

import static org.assertj.core.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.soleProprietor.model.Owner;
import com.example.soleProprietor.repository.NoticeRepository;
import com.example.soleProprietor.repository.OwnerRepository;
import com.example.soleProprietor.util.EntityProvider;

@RunWith(SpringRunner.class)
public class OwnerServiceImplTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public OwnerService employeeService() {
            return new OwnerServiceImpl();
        }
    }
 
    @Autowired
    private OwnerService ownerService;
 
    @MockBean
    private OwnerRepository ownerRepository;
    
    @MockBean
    private NoticeRepository noticeRepository;

    @Before
    public void setUp() {
    	Owner james = EntityProvider.getJames();
     
        Mockito.when(ownerRepository.findById(1))
          .thenReturn(james);
    }
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "James";
        Owner found = ownerService.findById(1);
      
         assertThat(found.getName())
          .isEqualTo(name);
     }
}
