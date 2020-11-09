package com.startup.controller.contact;

import com.startup.entity.contact.Contact;
import com.startup.factory.contact.ContactFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactControllerTest {

    private static Contact contact = ContactFactory.createContact("0782253152", "shabied007@gmail.com", "0212265468");
    private static String SECURITY_USERNAME = "user";
    private static String SECURITY_PASSWORD = "3585";

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String baseUrl = "http://localhost:8080/contact";

    @Test
    public void a_create(){
        String url = baseUrl + "create";
        System.out.println("URL: " + url + "\n" + "Contact: " + contact);
        ResponseEntity<Contact> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, contact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        contact = postResponse.getBody();
        System.out.println("saved Contact: " + postResponse);
        assertEquals(contact.getPhone(),postResponse.getBody().getPhone());

    }

    @Test
    public void b_read(){
        String url = baseUrl + "read/" + contact.getPhone();
        ResponseEntity<Contact> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Contact.class);
        assertEquals(contact.getPhone(), response.getBody().getPhone());

    }

    @Test
    public void c_update(){
        Contact updated = new Contact.Builder().setPhone("0824865875").setEmail("shade898@gmail.com").setHomephone("0212205684").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("post contact: " + updated);
        ResponseEntity<Contact> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, updated, Contact.class);
        System.out.println(response);
        System.out.println(response.getBody());


    }
    @Test
    public void d_getAll(){
        String url = baseUrl + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete(){
        String url = baseUrl + "delete/" + contact.getPhone();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}