package ATMtrans.controller.cardlessController;

import ATMtrans.domain.cardless.Ewallet;
import ATMtrans.factory.factoryCardless.EwalletFactory;
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
public class EwalletControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllEwallet() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetEwalletById(){
        Ewallet ewallet = restTemplate.getForObject( baseURL + "/ewallet/1", Ewallet.class);
        System.out.println(ewallet.getId());
        assertNotNull( ewallet );
    }

    @Test
    public void testCreateEwallet(){
        Ewallet ewallet= EwalletFactory.getAmount(25 );
        ResponseEntity<Ewallet> postResponse = restTemplate.postForEntity( baseURL +"/create",ewallet,Ewallet.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedEwallet(){
        int id = 1;
        Ewallet ewallet = restTemplate.getForObject( baseURL + "/ewallet/" + id, Ewallet.class );
        restTemplate.put( baseURL + "/AnotherBalance" + id, ewallet );
        Ewallet updatedEwallet = restTemplate.getForObject( baseURL + "/ewallet/" + id, Ewallet.class );
        assertNotNull( updatedEwallet );
    }
    @Test
    public void testDeleteEwalletDetails(){
        int id = 2;
        Ewallet ewallet = restTemplate.getForObject( baseURL + "/EwalletId/" + id, Ewallet.class );
        assertNotNull( ewallet );
        restTemplate.delete( baseURL + "/balances/" + id );
        try{
            ewallet= restTemplate.getForObject( baseURL + "/BalanceDetails/"+ id, Ewallet.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}