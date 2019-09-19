package ATMtrans.controller.cardlessController;

import ATMtrans.domain.cardless.CardlessService;
import ATMtrans.factory.factoryCardless.CardlessServiceFactory;
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
public class CardlessServiceControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllCardlessService() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetCardlessServiceById(){
        CardlessService cardlessService = restTemplate.getForObject( baseURL + "/cardlessService/1", CardlessService.class);
        System.out.println(cardlessService.getId());
        assertNotNull( cardlessService );
    }

    @Test
    public void testCreateCardlessService(){
        CardlessService cardlessService= CardlessServiceFactory.getType("..." );
        ResponseEntity<CardlessService> postResponse = restTemplate.postForEntity( baseURL +"/create",cardlessService,
                CardlessService.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedCardlessService(){
        int id = 1;
        CardlessService cardlessService = restTemplate.getForObject( baseURL + "/cardlessService/" + id, CardlessService.class );
        restTemplate.put( baseURL + "/AnotherBalance" + id, cardlessService );
        CardlessService updatedCardlessService = restTemplate.getForObject( baseURL + "/cardlessService/" + id, CardlessService.class );
        assertNotNull( updatedCardlessService );
    }
    @Test
    public void testDeleteCardlessServiceDetails(){
        int id = 2;
        CardlessService cardlessService = restTemplate.getForObject( baseURL + "/CardlessServiceId/" + id, CardlessService.class );
        assertNotNull( cardlessService );
        restTemplate.delete( baseURL + "/CardlessServices/" + id );
        try{
            cardlessService= restTemplate.getForObject( baseURL + "/CardlessServiceDetails/"+ id, CardlessService.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}