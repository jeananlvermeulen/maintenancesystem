package com.startup.controller.user;
/*Jéanan Vermeulen
* 215002725*/
import com.startup.entity.user.UserRole;
import com.startup.factory.user.UserRoleFactory;
import org.apache.catalina.User;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
public class UserRoleControllerTest {

   private static UserRole userRole = UserRoleFactory.buildUserRole("215002725");

   private TestRestTemplate restTemplate = new TestRestTemplate();
   private String baseUrl = "http://localhost:8080/userRole/";


   @Test
    public void a_create(){
       String url = baseUrl + "create";
       System.out.println("URL" + url);
       System.out.println("Post userRole" + userRole);
       ResponseEntity<UserRole> postResponse = restTemplate.postForEntity(url, userRole, UserRole.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
       userRole = postResponse.getBody();
       System.out.println("saved userRole" + userRole);
       assertEquals(userRole.getRoleId(),postResponse.getBody().getRoleId());
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
    public void b_read(){
        String url = baseUrl + "read/" + userRole.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<UserRole> response = restTemplate.getForEntity(url, UserRole.class);
        assertEquals(userRole.getUserId(), response.getBody().getUserId());
    }

    @Test
    public void c_update(){
       UserRole updated = new UserRole.Builder().copy(userRole).build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("post userRole: " + updated);
        ResponseEntity<UserRole> response = restTemplate.postForEntity(url, updated, UserRole.class);
        assertEquals(userRole.getRoleId(), response.getBody().getRoleId());
    }

    @Test
    public void e_delete(){
        String url = baseUrl + "delete/" + userRole.getRoleId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    }