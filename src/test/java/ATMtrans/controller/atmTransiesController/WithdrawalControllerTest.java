package ATMtrans.controller.atmTransiesController;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.factory.factoryAtmTransies.WithdrawalFactory;
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
public class WithdrawalControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllWithdrawal() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetWithdrawalById(){
        Withdrawal withdrawal = restTemplate.getForObject( baseURL + "/ withdrawal/1", Withdrawal.class);
        System.out.println( withdrawal.getId());
        assertNotNull(  withdrawal );
    }

    @Test
    public void testCreateWithdrawal(){
        Withdrawal withdrawal = WithdrawalFactory.getAmount( 450 );
        ResponseEntity<Withdrawal> postResponse = restTemplate.postForEntity( baseURL +"/create", withdrawal,Withdrawal.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedUser(){
        int id = 1;
        Withdrawal withdrawal = restTemplate.getForObject( baseURL + "/ withdrawal/" + id, Withdrawal.class );
        restTemplate.put( baseURL + "/AnotherBankName" + id, withdrawal );
        Withdrawal updatedWithdrawal = restTemplate.getForObject( baseURL + "/ withdrawal/" + id, Withdrawal.class );
        assertNotNull( updatedWithdrawal );
    }


    @Test
    public void testDeleteUserDetails(){
        int id = 2;
        Withdrawal withdrawal = restTemplate.getForObject( baseURL + "/ WithdrawalId/" + id, Withdrawal.class );
        assertNotNull(  withdrawal);
        restTemplate.delete( baseURL + "/ withdrawals/" + id );
        try{
            withdrawal= restTemplate.getForObject( baseURL + "/ WithdrawalDetails/"+ id, Withdrawal.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}