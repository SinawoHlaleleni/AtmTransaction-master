package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Check;
import ATMtrans.factory.factoryAccount.CheckFactory;
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
public class CheckControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/Check";

    @Test
    public void testGetAllCheck() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Ignore
    public void testGetCheckashAmount(){
        Check check = restTemplate.getForObject( baseURL + "/check/1",
                Check.class);
        System.out.println(check.getId());
        assertNotNull( check );
    }

    @Test
    public void testCreateBank(){
        Check check = CheckFactory.getAmount( 150);
        ResponseEntity<Check> postResponse = restTemplate.postForEntity( baseURL +"/create",check,Check.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedBank(){
        int id = 1;
        Check check = restTemplate.getForObject( baseURL + "/check/" + id, Check.class );
        restTemplate.put( baseURL + "/AnotherCheckAmount" + id, check );
        Check updatedBank = restTemplate.getForObject( baseURL + "/check/" + id, Check.class );
        assertNotNull( updatedBank );
    }


    @Test
    public void testDeleteBankDetails(){
        int id = 2;
        Check check = restTemplate.getForObject( baseURL + "/CheckId/" + id, Check.class );
        assertNotNull( check );
        restTemplate.delete( baseURL + "/check/" + id );
        try{
            check = restTemplate.getForObject( baseURL + "/CheckDetails/"+ id, Check.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }

}