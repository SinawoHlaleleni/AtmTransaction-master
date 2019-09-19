package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.Airtime;
import ATMtrans.factory.factoryAtmInfor.AirtimeFactory;
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
public class AirtimeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/Bank";

    @Test
    public void testGetAllBanks() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> respense = restTemplate.exchange(baseURL + "all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(respense.getBody());
    }
    @Test
    public void testGetAirtime(){
        Airtime airtime = restTemplate.getForObject( baseURL + "/airtime/1", Airtime.class);
        System.out.println(airtime.gettId());
        assertNotNull( airtime );
    }

    @Test
    public void testCreateAirtime(){
        Airtime airtime = AirtimeFactory.getAmount( 30);
        ResponseEntity<Airtime> postResponse = restTemplate.postForEntity( baseURL +"/create",airtime,Airtime.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedAirtime(){
        int id = 1;
        Airtime airtime = restTemplate.getForObject( baseURL + "/airtime/" + id,Airtime.class );
        restTemplate.put( baseURL + "/AnotherSavings" + id, airtime );
        Airtime updatedAirtime = restTemplate.getForObject( baseURL + "/airtime/" + id, Airtime.class );
        assertNotNull( updatedAirtime );
    }

    @Test
    public void testDeleteAirtimeDetails(){
        int id = 2;
        Airtime airtime = restTemplate.getForObject( baseURL + "/AirtimeId/" + id, Airtime.class );
        assertNotNull( airtime );
        restTemplate.delete( baseURL + "/airtime/" + id );
        try{
           airtime = restTemplate.getForObject( baseURL + "/AirtimeDetails/"+ id, Airtime.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}