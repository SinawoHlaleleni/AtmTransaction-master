package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Statement;
import ATMtrans.factory.factoryAccount.StatementFactory;
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
public class StatementControllerTest {

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
    public void testGetStatement(){
        Statement statement = restTemplate.getForObject( baseURL + "/statement/1",
                Statement.class);
        System.out.println(statement.getId());
        assertNotNull( statement );
    }

    @Test
    public void testCreateStatement(){
        Statement statement = StatementFactory.getType( "1 Month" );
        ResponseEntity<Statement> postResponse = restTemplate.postForEntity( baseURL +"/create",statement,Statement.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedStatement(){
        int id = 1;
        Statement statement = restTemplate.getForObject( baseURL + "/bank/" + id, Statement.class );
        restTemplate.put( baseURL + "/AnotherBankName" + id, statement );
        Statement updatedStatement = restTemplate.getForObject( baseURL + "/bank/" + id, Statement.class );
        assertNotNull( updatedStatement );
    }


    @Test
    public void testDeleteStatemDetails(){
        int id = 2;
        Statement statement = restTemplate.getForObject( baseURL + "/StatementId/" + id, Statement.class );
        assertNotNull( statement );
        restTemplate.delete( baseURL + "/statement/" + id );
        try{
            statement = restTemplate.getForObject( baseURL + "/BankDetails/"+ id, Statement.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }

}