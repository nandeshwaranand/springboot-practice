package com.springbootpractice.controller;

import com.springbootpractice.components.UserAccountResponseAssembler;
import com.springbootpractice.dto.response.UserAccountResponse;
import com.springbootpractice.entity.UserAccount;
import com.springbootpractice.service.UserAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
 class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserAccountService userAccountService;

    @Mock
    private UserAccountResponseAssembler responseAssembler;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setupMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testGetUserById() throws Exception {
        System.out.println("Test get user by id..");
        // Step 1: Define mock behavior
        when(responseAssembler.toModel(userAccountService.getUserAccountByUserId(1L)))
                .thenReturn(getUserAccountResponse());
        // Step 2: Perform GET request using MockMvc
        MvcResult result = mockMvc.perform(get("/users/1").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(1))
                .andReturn();

        System.out.println("Result:"+result.getResponse().getContentType());
    }

    UserAccountResponse getUserAccountResponse() {
        return UserAccountResponse.builder()
                .userId(1L)
                .firstName("Anand")
                .lastName("Nandeshwar")
                .mobile("8007400992")
                .username("nandeshwar.anand06@gmail.com")
                .build();
    }
}
