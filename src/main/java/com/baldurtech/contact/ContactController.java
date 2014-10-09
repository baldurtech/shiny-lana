package com.baldurtech.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value="contact")
public class ContactController {  
    ContactService contactService = new ContactService();
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String contactList(Model model) {
        model.addAttribute("contactList",contactService.getContactList());
        return "contact/list";
    }
}