package com.startup.controller.technician;

import com.startup.entity.technician.Profession;
import com.startup.factory.technician.ProfessionFactory;
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
public class ProfessionControllerTest {

    private static Profession profession = ProfessionFactory.buildProfession("IT Technician",
            "Everything about IT");

    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/profession/";


    @Test
    public void a_create(){
        String url = baseUrl + "create";
        System.out.println("URL" + url);
        System.out.println("Post profession" + profession);
        ResponseEntity<Profession> postResponse = restTemplate.postForEntity(url, profession, Profession.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        profession = postResponse.getBody();
        System.out.println("saved profession" + profession);
        assertEquals(profession.getProfessionId(),postResponse.getBody().getProfessionId());

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
        String url = baseUrl + "read/" + profession.getProfessionId();
        System.out.println("URL: " + url);
        ResponseEntity<Profession> response = restTemplate.getForEntity(url, Profession.class);
        assertEquals(profession.getProfessionId(), response.getBody().getProfessionId());
    }

    @Test
    public void c_update(){
        Profession updated = new Profession.Builder().copy(profession).name("Plumber").description("Everything about pipe").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("post profession: " + updated);
        ResponseEntity<Profession> response = restTemplate.postForEntity(url, updated, Profession.class);
        assertEquals(profession.getProfessionId(), response.getBody().getProfessionId());
    }

    @Test
    public void e_delete(){
        String url = baseUrl + "delete/" + profession.getProfessionId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }


}