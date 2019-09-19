package ATMtrans.controller.atmTransiesController;

import ATMtrans.domain.atmTransies.Deposit;
import ATMtrans.factory.factoryAtmTransies.DepositFactory;
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
public class DepositControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllDeposit() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetDepositById(){
        Deposit deposit = restTemplate.getForObject( baseURL + "/deposit/1", Deposit.class);
        System.out.println(deposit.getId());
        assertNotNull( deposit );
    }

    @Test
    public void testCreateDeposit(){
        Deposit deposit = DepositFactory.getAmount( 270 );
        ResponseEntity<Deposit> postResponse = restTemplate.postForEntity( baseURL +"/create",deposit,Deposit.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedUserDeposit(){
        int id = 1;
        Deposit deposit= restTemplate.getForObject( baseURL + "/deposit/" + id, Deposit.class );
        restTemplate.put( baseURL + "/AnotherBankName" + id, deposit );
        Deposit updatedDeposit = restTemplate.getForObject( baseURL + "/deposit/" + id, Deposit.class );
        assertNotNull( updatedDeposit );
    }


    @Test
    public void testDeleteDepositDetails(){
        int id = 2;
       Deposit deposit = restTemplate.getForObject( baseURL + "/DepositId/" + id, Deposit.class );
        assertNotNull( deposit );
        restTemplate.delete( baseURL + "/users/" + id );
        try{
            deposit = restTemplate.getForObject( baseURL + "/DepositDetails/"+ id, Deposit.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}