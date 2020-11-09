package com.startup.controller.technician;
import com.startup.entity.technician.MaintenanceProf;
import com.startup.factory.technician.MaintenanceProfFactory;
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
public class MaintenanceProfControllerTest {

    private static MaintenanceProf maintenanceProf = MaintenanceProfFactory.buildMaintenanceProf("215002725");
    private static String  SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "3585";

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String baseUrl = "http://localhost:8080/maintenanceprof/";


    @Test
    public void a_create(){
        String url = baseUrl + "create";
        System.out.println("URL" + url);
        System.out.println("Post maintenance profession" + maintenanceProf);
        ResponseEntity<MaintenanceProf> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD )
                .postForEntity(url, maintenanceProf, MaintenanceProf.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        maintenanceProf = postResponse.getBody();
        System.out.println("saved maintenance profession" + maintenanceProf);
        assertEquals(maintenanceProf.getProfessionId(),postResponse.getBody().getMaintenanceId());
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
    public void b_read(){
        String url = baseUrl + "read/" + maintenanceProf.getMaintenanceId();
        System.out.println("URL: " + url);
        ResponseEntity<MaintenanceProf> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, MaintenanceProf.class);
        maintenanceProf = response.getBody();
        assertEquals(maintenanceProf.getProfessionId(), response.getBody().getProfessionId());
    }

    @Test
    public void c_update(){
        MaintenanceProf updated = new MaintenanceProf.Builder().copy(maintenanceProf).build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("post maintenance profession: " + updated);
        ResponseEntity<MaintenanceProf> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, MaintenanceProf.class);
        assertEquals(maintenanceProf.getProfessionId(), response.getBody().getProfessionId());
    }

    @Test
    public void e_delete(){
        String url = baseUrl + "delete/" + maintenanceProf.getProfessionId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }


}