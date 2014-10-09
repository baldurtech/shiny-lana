package com.baldurtech.contact;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class ContactControllerTest {
    MockMvc mockMvc;
    
    @InjectMocks
    ContactController controller;
    
    @Mock 
    ContactService contactService;
    
    @Before
    public void setup() {
        
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller)
				.setViewResolvers(viewResolver())
				.build();
    }
    
     private InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".html");
		return viewResolver;
	}
    
    @Test
    public void displaysContactList() throws Exception {
         mockMvc.perform(get("/contact/list"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("contactList"))
            .andExpect(view().name(is("contact/list")));
            
         verify(contactService).getContactList();
    }
}