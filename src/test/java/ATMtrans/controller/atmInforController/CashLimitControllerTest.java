package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.CashLimit;
import ATMtrans.factory.factoryAtmInfor.CashLimitFactory;
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
public class CashLimitControllerTest {

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
        CashLimit cashLimit = restTemplate.getForObject( baseURL + "/cahslimit/1",
                CashLimit.class);
        System.out.println(cashLimit.getId());
        assertNotNull( cashLimit );
    }

    @Test
    public void testCreateCashLimit(){
        CashLimit cashLimit = CashLimitFactory.getAmount( 300);
        ResponseEntity<CashLimit> postResponse = restTemplate.postForEntity( baseURL +"/create",cashLimit,CashLimit.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedCashLimit(){
        int id = 1;
        CashLimit cashLimit = restTemplate.getForObject( baseURL + "/cashLimit/" + id,CashLimit.class );
        restTemplate.put( baseURL + "/AnotherCashLimit" + id, cashLimit );
        CashLimit updatedCash = restTemplate.getForObject( baseURL + "/cashLimit/" + id, CashLimit.class );
        assertNotNull( updatedCash );
    }
    @Test
    public void testDeleteCashDetails(){
        int id = 2;
        CashLimit cashLimit = restTemplate.getForObject( baseURL + "/CashLimitId/" + id, CashLimit.class );
        assertNotNull( cashLimit );
        restTemplate.delete( baseURL + "/cashLimit/" + id );
        try{
            cashLimit = restTemplate.getForObject( baseURL + "/BankDetails/"+ id, CashLimit.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}