package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.Topup;
import ATMtrans.factory.factoryAtmInfor.TopupFactory;
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
public class TopupControllerTest {

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
    public void testGetTopup(){
        Topup topup = restTemplate.getForObject( baseURL + "/topup/1", Topup.class);
        System.out.println(topup.getId());
        assertNotNull( topup );
    }
    @Test
    public void testCreateTopup(){
        Topup topup = TopupFactory.getType( "Vodacom");
        ResponseEntity<Topup> postResponse = restTemplate.postForEntity( baseURL +"/create",topup,Topup.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }
    @Test
    public void testUpdatedTopup(){
        int id = 1;
        Topup topup = restTemplate.getForObject( baseURL + "/topup/" + id,Topup.class );
        restTemplate.put( baseURL + "/AnotherTopup" + id, topup );
        Topup updatedTop = restTemplate.getForObject( baseURL + "/topup/" + id, Topup.class );
        assertNotNull( updatedTop );
    }
    @Test
    public void testDeleteTopupDetails(){
        int id = 2;
        Topup topup = restTemplate.getForObject( baseURL + "/TopupId/" + id, Topup.class );
        assertNotNull( topup );
        restTemplate.delete( baseURL + "/topup/" + id );
        try{
            topup = restTemplate.getForObject( baseURL + "/TopupDetails/"+ id,Topup.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}