package ATMtrans.controller.ordersController;

import ATMtrans.domain.orders.CreditOrder;
import ATMtrans.factory.factoryOrders.CreditOrderFactory;
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
public class CreditOrderControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllCreditOrder() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetCreditOrderById(){
        CreditOrder creditOrder = restTemplate.getForObject( baseURL + "/creditOrder/1", CreditOrder.class);
        System.out.println(creditOrder.getId());
        assertNotNull( creditOrder );
    }

    @Test
    public void testCreateCreditOrder(){
        CreditOrder creditOrder= CreditOrderFactory.getAmount(25 );
        ResponseEntity<CreditOrder> postResponse = restTemplate.postForEntity( baseURL +"/create",creditOrder,CreditOrder.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedCreditOrder(){
        int id = 1;
        CreditOrder creditOrder = restTemplate.getForObject( baseURL + "/creditOrder/" + id, CreditOrder.class );
        restTemplate.put( baseURL + "/AnotherCreditOrder" + id, creditOrder );
        CreditOrder updatedCreditOrder = restTemplate.getForObject( baseURL + "/creditOrder/" + id, CreditOrder.class );
        assertNotNull( updatedCreditOrder );
    }
    @Test
    public void testDeleteCreditOrderDetails(){
        int id = 2;
        CreditOrder creditOrder = restTemplate.getForObject( baseURL + "/CreditOrderId/" + id, CreditOrder.class );
        assertNotNull( creditOrder );
        restTemplate.delete( baseURL + "/creditOrder/" + id );
        try{
            creditOrder= restTemplate.getForObject( baseURL + "/CreditOrderDetails/"+ id, CreditOrder.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}