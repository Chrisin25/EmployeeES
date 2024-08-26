package com.example.EmployeeDb.exception;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.EmployeeDb.controller.EmployeeController;
import com.example.EmployeeDb.service.EmployeeService;

@WebMvcTest
public class GlobalExceptionHandlerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeController employeeController;
    @MockBean
    private EmployeeService employeeService;

   
    @Test
    public void testHandleMethodArgumentNotValidException() throws Exception {
        MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);
        FieldError fieldError = new FieldError("objectName", "fieldName", "defaultMessage");
        List<FieldError> fieldErrors = Collections.singletonList(fieldError);
        
        when(ex.getFieldErrors()).thenReturn(fieldErrors);

        // Act
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<Map<String, String>> response = handler.handleArgumentExceptions(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("defaultMessage", response.getBody().get("fieldName"));
    }
    @Test
    public void testHandleMethodArgumentTypeMismatchException()throws Exception{
        
        mockMvc.perform(get("/ViewEmployee")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("year-of-experience", "i"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.yearOfExperience").value("give a valid yearOfExperience"));
        
    }
    
}
