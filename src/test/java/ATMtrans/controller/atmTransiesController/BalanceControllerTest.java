package ATMtrans.controller.atmTransiesController;

import ATMtrans.domain.atmTransies.Balance;
import ATMtrans.factory.factoryAtmTransies.BalanceFactory;
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
public class BalanceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllBalance() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetBalanceById(){
        Balance balance = restTemplate.getForObject( baseURL + "/user/1", Balance.class);
        System.out.println(balance.getId());
        assertNotNull( balance );
    }

    @Test
    public void testCreateUser(){
        Balance balance= BalanceFactory.getAmount(25 );
        ResponseEntity<Balance> postResponse = restTemplate.postForEntity( baseURL +"/create",balance,Balance.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedBalance(){
        int id = 1;
        Balance balance = restTemplate.getForObject( baseURL + "/balance/" + id, Balance.class );
        restTemplate.put( baseURL + "/AnotherBalance" + id, balance );
        Balance updatedBalance = restTemplate.getForObject( baseURL + "/balance/" + id, Balance.class );
        assertNotNull( updatedBalance );
    }
    @Test
    public void testDeleteBalanceDetails(){
        int id = 2;
        Balance balance = restTemplate.getForObject( baseURL + "/BalanceId/" + id, Balance.class );
        assertNotNull( balance );
        restTemplate.delete( baseURL + "/balances/" + id );
        try{
            balance= restTemplate.getForObject( baseURL + "/BalanceDetails/"+ id, Balance.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}