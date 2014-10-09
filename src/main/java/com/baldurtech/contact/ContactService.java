package com.baldurtech.contact;

import java.util.List;
import java.util.ArrayList;

public class ContactService {
    public List<Contact> getContactList() {
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
        return contactList;
    }
}