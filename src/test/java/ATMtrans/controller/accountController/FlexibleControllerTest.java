package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Flexible;
import ATMtrans.factory.factoryAccount.FlexibleFactory;
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
public class FlexibleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/Bank";

    @Test
    public void testGetAllBanks() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetBankNames(){
        Flexible flexible = restTemplate.getForObject( baseURL + "/flexible/1",
                Flexible.class);
        System.out.println(flexible.getId());
        assertNotNull( flexible );
    }

    @Test
    public void testCreateFlexible(){
        Flexible flexible = FlexibleFactory.getAmount( 250 );
        ResponseEntity<Flexible> postResponse = restTemplate.postForEntity( baseURL +"/create",flexible,Flexible.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedFlexible(){
        int id = 1;
        Flexible flexible = restTemplate.getForObject( baseURL + "/flexible/" + id, Flexible.class );
        restTemplate.put( baseURL + "/AnotherBankName" + id, flexible );
        Flexible updatedFlexible = restTemplate.getForObject( baseURL + "/flexible/" + id, Flexible.class );
        assertNotNull( updatedFlexible );
    }


    @Test
    public void testDeleteBankDetails(){
        int id = 2;
        Flexible flexible = restTemplate.getForObject( baseURL + "/FlexibleId/" + id, Flexible.class );
        assertNotNull( flexible );
        restTemplate.delete( baseURL + "/flexible/" + id );
        try{
            flexible = restTemplate.getForObject( baseURL + "/FlaxibleDetails/"+ id, Flexible.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }

}