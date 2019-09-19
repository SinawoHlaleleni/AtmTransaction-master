package ATMtrans.controller.bankInforController;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.domain.bankInfor.Bank;
import ATMtrans.factory.factoryAtmTransies.UserFactory;
import ATMtrans.factory.factoryBankInfor.BankFactory;
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
public class BankControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/Bank";

    @Test
    public void testGetAllBanks() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String>respense = restTemplate.exchange(baseURL + "all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(respense.getBody());
    }
    @Test
    public void testGetBankNames(){
        Bank bank = restTemplate.getForObject( baseURL + "/bank/1",
                Bank.class);
        System.out.println(bank.getId());
        assertNotNull( bank );
    }

    @Test
    public void testCreateBank(){
        Bank bank = BankFactory.getName( "Standard Bank" );
        ResponseEntity<Bank> postResponse = restTemplate.postForEntity( baseURL +"/create",bank,Bank.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedBank(){
        int id = 1;
        Bank bank = restTemplate.getForObject( baseURL + "/bank/" + id, Bank.class );
        restTemplate.put( baseURL + "/AnotherBankName" + id, bank );
        Bank updatedBank = restTemplate.getForObject( baseURL + "/bank/" + id, Bank.class );
        assertNotNull( updatedBank );
    }


    @Test
    public void testDeleteBankDetails(){
        int id = 2;
        Bank bank = restTemplate.getForObject( baseURL + "/BankId/" + id, Bank.class );
        assertNotNull( bank );
        restTemplate.delete( baseURL + "/bank/" + id );
        try{
            bank = restTemplate.getForObject( baseURL + "/BankDetails/"+ id, Bank.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }

}