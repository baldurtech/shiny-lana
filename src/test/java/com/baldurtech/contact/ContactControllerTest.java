package com.baldurtech.contact;

import org.junit.Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.baldurtech.config.WebAppConfigurationAware;

public class ContactControllerTest extends WebAppConfigurationAware{
    @Test
    public void displayContactList() throws Exception {
        mockMvc.perform(get("/contact/list"))
                .andExpect(view().name("contact/list"))
                .andExpect(content().string(
                        allOf(
                                containsString("<title>ContactList</title>"),
                                containsString("<legend>Contact List</legend>")
                        ))
                );
    }
}