package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Savings;
import ATMtrans.factory.factoryAccount.SavingsFactory;
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
public class SavingsControllerTest {

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
    public void testGetSavings(){
        Savings savings = restTemplate.getForObject( baseURL + "/savings/1",
                Savings.class);
        System.out.println(savings.getId());
        assertNotNull( savings );
    }

    @Test
    public void testCreateSavings(){
        Savings savings = SavingsFactory.getAmount( 300);
        ResponseEntity<Savings> postResponse = restTemplate.postForEntity( baseURL +"/create",savings,Savings.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedSavings(){
        int id = 1;
       Savings savings = restTemplate.getForObject( baseURL + "/savings/" + id,Savings.class );
        restTemplate.put( baseURL + "/AnotherSavings" + id, savings );
        Savings updatedSavings = restTemplate.getForObject( baseURL + "/savings/" + id, Savings.class );
        assertNotNull( updatedSavings );
    }


    @Test
    public void testDeleteSavingsDetails(){
        int id = 2;
        Savings savings = restTemplate.getForObject( baseURL + "/BankId/" + id, Savings.class );
        assertNotNull( savings );
        restTemplate.delete( baseURL + "/bank/" + id );
        try{
            savings = restTemplate.getForObject( baseURL + "/BankDetails/"+ id, Savings.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }

}