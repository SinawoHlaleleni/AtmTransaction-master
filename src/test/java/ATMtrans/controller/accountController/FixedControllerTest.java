package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Fixed;
import ATMtrans.factory.factoryAccount.FixedFactory;
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
public class FixedControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/Bank";

    @Test
    public void testGetAllFixed() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> respense = restTemplate.exchange(baseURL + "all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(respense.getBody());
    }
    @Test
    public void testGetFixedAmount(){
        Fixed fixed = restTemplate.getForObject( baseURL + "/fixed/1",
                Fixed.class);
        System.out.println(fixed.getId());
        assertNotNull( fixed );
    }

    @Test
    public void testCreateFixed(){
       Fixed fixed = FixedFactory.getAmount( 200);
        ResponseEntity<Fixed> postResponse = restTemplate.postForEntity( baseURL +"/create",fixed,Fixed.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedFixed(){
        int id = 1;
       Fixed fixed = restTemplate.getForObject( baseURL + "/fixed/" + id, Fixed.class );
        restTemplate.put( baseURL + "/AnotherBankName" + id, fixed );
        Fixed UpdatedFixed = restTemplate.getForObject( baseURL + "/bank/" + id, Fixed.class );
        assertNotNull(UpdatedFixed );
    }


    @Test
    public void testDeleteFixDetails(){
        int id = 2;
        Fixed fixed = restTemplate.getForObject( baseURL + "/FixedId/" + id, Fixed.class );
        assertNotNull( fixed );
        restTemplate.delete( baseURL + "/fixed/" + id );
        try{
            fixed = restTemplate.getForObject( baseURL + "/BankDetails/"+ id, Fixed.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }

}