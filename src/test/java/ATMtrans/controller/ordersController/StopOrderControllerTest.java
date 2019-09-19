package ATMtrans.controller.ordersController;

import ATMtrans.domain.orders.StopOrder;
import ATMtrans.factory.factoryOrders.StopOrderFactory;
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
public class StopOrderControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllStopOrder() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetStopOrderById(){
        StopOrder stopOrder = restTemplate.getForObject( baseURL + "/stopOrder/1", StopOrder.class);
        System.out.println(stopOrder.getId());
        assertNotNull( stopOrder );
    }

    @Test
    public void testCreateStopOrder(){
        StopOrder stopOrder= StopOrderFactory.getAmount(25 );
        ResponseEntity<StopOrder> postResponse = restTemplate.postForEntity( baseURL +"/create",stopOrder,StopOrder.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedStopOrder(){
        int id = 1;
        StopOrder stopOrder = restTemplate.getForObject( baseURL + "/stopOrder/" + id, StopOrder.class );
        restTemplate.put( baseURL + "/AnotherStopOrder" + id, stopOrder );
        StopOrder updatedBalance = restTemplate.getForObject( baseURL + "/stopOrder/" + id, StopOrder.class );
        assertNotNull( updatedBalance );
    }
    @Test
    public void testDeleteStopOrderDetails(){
        int id = 2;
        StopOrder stopOrder = restTemplate.getForObject( baseURL + "/StopOrderId/" + id, StopOrder.class );
        assertNotNull( stopOrder );
        restTemplate.delete( baseURL + "/stopOrders/" + id );
        try{
            stopOrder= restTemplate.getForObject( baseURL + "/StopOrderDetails/"+ id, StopOrder.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}