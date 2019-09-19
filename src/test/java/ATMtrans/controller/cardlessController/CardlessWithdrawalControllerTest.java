package ATMtrans.controller.cardlessController;

import ATMtrans.domain.cardless.CardlessWithdrawal;
import ATMtrans.factory.factoryCardless.CardlessWithdrawalFactory;
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
public class CardlessWithdrawalControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllCardlessWithdrawal() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetCardlessWithdrawalById(){
        CardlessWithdrawal cardlessWithdrawal = restTemplate.getForObject( baseURL + "/cardlessWithdrawal/1", CardlessWithdrawal.class);
        System.out.println(cardlessWithdrawal.getId());
        assertNotNull( cardlessWithdrawal );
    }

    @Test
    public void testCreateCardlessWithdrawal(){
        CardlessWithdrawal cardlessWithdrawal= CardlessWithdrawalFactory.getAmount(25 );
        ResponseEntity<CardlessWithdrawal> postResponse = restTemplate.postForEntity( baseURL +"/create",cardlessWithdrawal
                ,CardlessWithdrawal.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedCardlessWithdrawal(){
        int id = 1;
        CardlessWithdrawal cardlessWithdrawal = restTemplate.getForObject( baseURL + "/cardlessWithdrawal/" + id, CardlessWithdrawal.class );
        restTemplate.put( baseURL + "/AnotherCardlessWithdrawal" + id, cardlessWithdrawal );
        CardlessWithdrawal updatedBalance = restTemplate.getForObject( baseURL + "/balance/" + id,
                CardlessWithdrawal.class );
        assertNotNull( updatedBalance );
    }
    @Test
    public void testDeleteCardlessWithdrawalDetails(){
        int id = 2;
        CardlessWithdrawal cardlessWithdrawal = restTemplate.getForObject( baseURL + "/BalanceId/" + id, CardlessWithdrawal.class );
        assertNotNull( cardlessWithdrawal );
        restTemplate.delete( baseURL + "/balances/" + id );
        try{
            cardlessWithdrawal= restTemplate.getForObject( baseURL + "/BalanceDetails/"+ id, CardlessWithdrawal.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}