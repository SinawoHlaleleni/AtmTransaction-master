package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.CashTransfer;
import ATMtrans.factory.factoryAtmInfor.CashTransferFactory;
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
public class CashTransferControllerTest {

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
    public void testGetCashTransfer(){
       CashTransfer cashTransfer = restTemplate.getForObject( baseURL + "/CashTransfer/1",
                CashTransfer.class);
        System.out.println(cashTransfer.getId());
        assertNotNull( cashTransfer );
    }

    @Test
    public void testCreateCashTransfer(){
        CashTransfer cashTransfer = CashTransferFactory.getAmount( 300);
        ResponseEntity<CashTransfer> postResponse = restTemplate.postForEntity( baseURL +"/create",cashTransfer,
                CashTransfer.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedCashTransfer(){
        int id = 1;
        CashTransfer cashTransfer = restTemplate.getForObject( baseURL + "/cashTransfer/" + id,CashTransfer.class );
        restTemplate.put( baseURL + "/AnotherSavings" + id, cashTransfer );
        CashTransfer updatedCash = restTemplate.getForObject( baseURL + "/savings/" + id, CashTransfer.class );
        assertNotNull( updatedCash );
    }


    @Test
    public void testDeleteCashTransDetails(){
        int id = 2;
        CashTransfer cashTransfer = restTemplate.getForObject( baseURL + "/BankId/" + id, CashTransfer.class );
        assertNotNull( cashTransfer);
        restTemplate.delete( baseURL + "/bank/" + id );
        try{
            cashTransfer = restTemplate.getForObject( baseURL + "/BankDetails/"+ id, CashTransfer.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}