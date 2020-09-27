package com.startup.controller.contact;



import com.startup.entity.contact.Address;
import com.startup.factory.contact.AddressFactory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressControllerTest {

    private static Address address = AddressFactory.buildAddress("10 Dorsert street", "PO BOX 33069 Drycott");
    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();

    private String baseUrl = "http://localhost:8080/address/";

    @Test
    public void a_create(){
        String url = baseUrl + "create";
        System.out.println("URL: " + url + "\n" +"Post address:" + address);
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(url, address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        address = postResponse.getBody();
        System.out.println("saved Addresses: " + postResponse);
        assertEquals(address.getPhysicalAddress(),postResponse.getBody().getPhysicalAddress());

    }

    @Test
    public void b_read(){
        String url = baseUrl + "read/" + address.getAddressId();
        ResponseEntity<Address> response = restTemplate.getForEntity(url, Address.class);
        assertEquals(address.getAddressId(), response.getBody().getAddressId());
    }

    @Test
    public void c_update(){
        Address updated = new Address.Builder().copy(address).physicalAddress("Estcourt 3304 Loskop").postalAddress("P.O Box 45321").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("post address: " + updated);
        ResponseEntity<Address> response = restTemplate.postForEntity(url,updated, Address.class);
        System.out.println(response);
        assertEquals(address.getAddressId(), response.getBody().getAddressId());
    }

    @Test
    public void d_getAll(){
        String url = baseUrl + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }

    @Test
    public void e_delete(){
        String url = baseUrl + "delete/" + address.getPhysicalAddress();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }


}