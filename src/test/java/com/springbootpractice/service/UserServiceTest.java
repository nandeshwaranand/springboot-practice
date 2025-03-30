package com.springbootpractice.service;

import com.springbootpractice.dto.response.UserAccountResponse;
import com.springbootpractice.entity.UserAccount;
import com.springbootpractice.exception.UserNotFoundException;
import com.springbootpractice.respository.UserAccountRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Enables Mockito support
 class UserServiceTest {

     /**
     * to create a mock object
     * Mocking an object means creating a fake version of a real object to test your code
     * without relying on the actual implementation.
     * his is useful when your code interacts with external dependencies (e.g., databases, APIs, or services),
      */
     @Mock  // Mock the repository
    // Step 1: Create a mock object of UserRepository
    private UserAccountRepository userAccountRepository; // = mock(UserAccountRepository.class);
    // Step 3: Inject mock into UserService
    @InjectMocks
    private UserAccountService userAccountService;// = new UserAccountService(userAccountRepository);

    //Called before every test execution
    @BeforeEach
    void beforeEach(){
        System.out.println("Before each for called..");
    }

    // Called after every test execution
    @AfterEach
    void afterEach(){
        System.out.println("After each called..");
    }

    //Called before starting of test execution one time
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all called..");
    }

    //Called after all test execution one time
    @AfterAll
    static void afterAll(){
        System.out.println("After all called..");
    }

    @Test
     void testGetUserById(){
        System.out.println("Get user test.");
        /*
         *  Step 2: Define behavior (stubbing)
         *  This tells Mockito: "Whenever findById(1) is called, return a user account object.
         */
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.ofNullable(getUserAccount()));
        // Step 4: Test the method
        UserAccount userAccount =  userAccountService.getUserAccountByUserId(1L);
        // Step 5: Assertions
        assertNotNull(userAccount);
        assertEquals("Anand", userAccount.getFirstName());
        // Step 6: Verify interaction
        verify(userAccountRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserById_NotFound() {
        // Arrange: Simulate user not found
        when(userAccountRepository.findById(1L)).thenReturn(Optional.empty());
        // Act & Assert: Expect an exception
        assertThrows(UserNotFoundException.class, () -> userAccountService.getUserAccountByUserId(1L));
        // Verify method call
        verify(userAccountRepository, times(1)).findById(1L);
    }

    UserAccount getUserAccount(){
        return UserAccount.builder()
                .userAccountId(1L)
                .firstName("Anand")
                .lastName("Nandeshwar")
                .mobile("8007400992")
                .username("nandeshwar.anand06@gmail.com")
                .build();
    }
}
