package com.baldurtech.contact;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping(value="contact")
public class ContactController {
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String contactList(Model model) {
        List<Contact> contactList = new ArrayList<Contact>();
        Contact contact = new Contact();
        contact.setName("Shi Hang");
        contact.setMobile("15235432994");
        contact.setVpmn("652994");
        contact.setEmail("123@qq.com");
        contact.setHomeAddress("shanxi");
        
        Contact contact2 = new Contact();
        contact2.setName("Xiao Bai");
        contact2.setMobile("18235100872");
        contact2.setVpmn("650872");
        contact2.setEmail("456@qq.com");
        contact2.setHomeAddress("taiyuan");
        
        contactList.add(contact);
        contactList.add(contact2);
        
        model.addAttribute("contactList",contactList);
        return "contact/list";
    }
}