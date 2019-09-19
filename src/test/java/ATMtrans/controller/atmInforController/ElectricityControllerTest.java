package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.Electricity;
import ATMtrans.factory.factoryAtmInfor.ElectricityFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ElectricityControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllUser() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetElectricById(){
        Electricity electricity = restTemplate.getForObject( baseURL + "/electricity/1", Electricity.class);
        System.out.println(electricity.getId());
        assertNotNull( electricity );
    }

    @Test
    public void testCreateElectricity(){
        Electricity electricity = ElectricityFactory.getAmount( 70);
        ResponseEntity<Electricity> postResponse = restTemplate.postForEntity( baseURL +"/create",electricity,Electricity.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedElectricity(){
        int id = 1;
        Electricity electricity = restTemplate.getForObject( baseURL + "/electricity/" + id, Electricity.class );
        restTemplate.put( baseURL + "/AnotherElectricity" + id, electricity );
        Electricity updatedElectr = restTemplate.getForObject( baseURL + "/electricity/" + id, Electricity.class );
        assertNotNull( updatedElectr );
    }

    @Test
    public void testDeleteElectricityDetails(){
        int id = 2;
        Electricity electricity = restTemplate.getForObject( baseURL + "/ElectricityId/" + id, Electricity.class );
        assertNotNull( electricity );
        restTemplate.delete( baseURL + "/electricity/" + id );
        try{
            electricity = restTemplate.getForObject( baseURL + "/ElectricityDetails/"+ id, Electricity.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}