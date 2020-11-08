package com.startup.controller.user;

import com.startup.entity.contact.Address;
import com.startup.entity.technician.Profession;
import com.startup.entity.user.User;
import com.startup.factory.user.UserFactory;
import org.junit.Before;
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
public class UserControllerTest {

    private static User user = UserFactory.buildUser("Minenhle", "Ngwenya");
    private static String  SECURITY_USERNAME = "user";
    private static String SECURITY_PASSWORD = "3585";

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String baseUrl = "http://localhost:8080/user/";

    @Test
    public void a_create(){
        String url = baseUrl + "create";
        System.out.println("URL" + url + "\n" +"Post address:" + user);
        ResponseEntity<User> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        user = postResponse.getBody();
        System.out.println("saved profession" + user);
        assertEquals(user.getName(),postResponse.getBody().getName());

    }

    @Test
    public void d_getAll(){
        String url = baseUrl + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }

    @Test
    public void b_read(){
        String url = baseUrl + "read/" + user.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<User> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).getForEntity(url, User.class);
        assertEquals(user.getUserId(), response.getBody().getUserId());
    }

    @Test
    public void c_update(){
        User updated = new User.Builder().copy(user).name("Ayanda").lastname("Malinga").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("post user: " + updated);
        ResponseEntity<User> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updated, User.class);
        System.out.println(response);
        assertEquals(user.getUserId(), response.getBody().getUserId());
    }

    @Test
    public void e_delete(){
        String url = baseUrl + "delete/" + user.getUserId();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }


}