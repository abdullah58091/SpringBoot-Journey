package com.example.myfirstProject.service;

import com.example.myfirstProject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JournalEntryService journalEntryService;


    @ParameterizedTest
    @ValueSource(strings =  {
            "Abdullah",
            "Aman",
            "Joe"
    })
    public  void  testFindByUserName(String name ) {

        // example for this file class
        assertEquals(4, 2 + 2);
        assertTrue(5 > 3);

        // It is project work
        assertNotNull(userRepository.findByUserName(name),"failed for :" + name);
    }


    @ParameterizedTest
    @CsvSource({
            " 1, 1,2",
            "2,10,12",
            "3,3,9"
    })
    public  void  test(int a , int b, int expected){
        assertEquals(expected,a+b);
    }
}
