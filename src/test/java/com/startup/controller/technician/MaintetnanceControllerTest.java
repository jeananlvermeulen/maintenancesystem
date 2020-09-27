package com.startup.controller.technician;

import com.startup.entity.technician.Maintenance;
import com.startup.entity.technician.Profession;
import com.startup.factory.technician.MaintenanceFactory;
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
public class MaintetnanceControllerTest {

    private static Maintenance maintenance = MaintenanceFactory.buildMaintenance("Christ",
            "Nganga");

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String baseUrl = "http://localhost:8080/maintenance/";

    @Test
    public void a_create(){
        String url = baseUrl + "create";
        System.out.println("URL" + url);
        System.out.println("Post maintenance" + maintenance);
        ResponseEntity<Maintenance> postResponse = restTemplate.postForEntity(url, maintenance, Maintenance.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        maintenance = postResponse.getBody();
        System.out.println("saved Maintenance" + maintenance);
        assertEquals(maintenance.getMaintenanceId(),postResponse.getBody().getMaintenanceId());

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
        String url = baseUrl + "read/" + maintenance.getMaintenanceId();
        System.out.println("URL: " + url);
        ResponseEntity<Maintenance> response = restTemplate.getForEntity(url, Maintenance.class);
        assertEquals(maintenance.getMaintenanceId(), response.getBody().getMaintenanceId());
    }

    @Test
    public void c_update(){
        Maintenance updated = new Maintenance.Builder().copy(maintenance).name("Amour").lastname("Moussiessi").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("post maintenance: " + updated);
        ResponseEntity<Maintenance> response = restTemplate.postForEntity(url, updated, Maintenance.class);
        assertEquals(maintenance.getMaintenanceId(), response.getBody().getMaintenanceId());
    }

    @Test
    public void e_delete(){
        String url = baseUrl + "delete/" + maintenance.getMaintenanceId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

}