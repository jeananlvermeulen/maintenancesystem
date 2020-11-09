package com.startup.controller.user;

import com.startup.entity.user.Role;
import com.startup.factory.user.RoleFactory;
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

import java.util.Objects;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleControllerTest {

 private   Role role = RoleFactory.buildRole("3354","Electrician");
 private static String SECURITY_USERNAME ="user";
 private static String SECURITY_PASSWORD ="3585";

 @Autowired
    private TestRestTemplate restTemplate= new TestRestTemplate();
    private String baseURL ="http://localhost:8080/role/";


    public void a_create(){
        String url = baseURL + "create";
        System.out.println("URL: "+ url);
        System.out.println("Post  role:" + role);
        ResponseEntity <Role> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, role, Role.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        role =postResponse.getBody();
        System.out.println("Saved role " + role);
        assertEquals(role.getRoleId(),postResponse.getBody().getRoleId());
    }

    @Test
    public void d_getAll(){
        String url = baseURL +"all";
        System.out.println("URL:"+ url);
        HttpHeaders header=new HttpHeaders();
        HttpEntity<String> entity= new HttpEntity<>(null,header);
        ResponseEntity<String> response =restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }
    @Test
    public void b_read(){
        String url =baseURL +"read/"+ role.getRoleId();
        System.out.println("URL:"+ url);
        ResponseEntity<Role> response=restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).getForEntity(url,Role.class);
        role =response.getBody();
        assertEquals(role.getRoleId(),response.getBody().getRoleId());


    }
    @Test
    public void c_update(){
        Role updated =new Role.Builder().copy(role).roleId("3232").setType("Plamber").build();
      //Role updated =new Role.Builder().copy(role).roleId("3232").build();
        String url =baseURL+ "update/";
        System.out.println("URL: " + url);
        System.out.println("post Role:"+updated);
        ResponseEntity<Role>response=restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url,updated,Role.class);
       role=response.getBody();
        System.out.println(response);
        assertEquals(role.getRoleId(),response.getBody().getRoleId());


    }
    @Test
    public void e_delete(){
        String url = baseURL+"delete/"+role.getRoleId() +role.getRoleId();
        System.out.println("URL"+url);
        restTemplate.delete(url);
    }


}