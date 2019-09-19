package ATMtrans.controller.atmTransiesController;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.factory.factoryAtmTransies.UserFactory;
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
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllUser() {
       HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>("User", headers);
        ResponseEntity<String>response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetUserById(){
        User user = restTemplate.getForObject( baseURL + "/user/1", User.class);
        System.out.println(user.getUserId());
        assertNotNull( user );
    }

    @Test
    public void testCreateUser(){
        User user = UserFactory.getUser( "Sinawo94", "Snw974" );
        ResponseEntity<User> postResponse = restTemplate.postForEntity( baseURL +"/create",user,User.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedUser(){
        int id = 1;
        User user = restTemplate.getForObject( baseURL + "/user/" + id, User.class );
        restTemplate.put( baseURL + "/AnotherBankName" + id, user );
        User updatedUser = restTemplate.getForObject( baseURL + "/user/" + id, User.class );
        assertNotNull( updatedUser );
    }


    @Test
    public void testDeleteUserDetails(){
        int id = 2;
        User user = restTemplate.getForObject( baseURL + "/UserId/" + id, User.class );
        assertNotNull( user );
        restTemplate.delete( baseURL + "/users/" + id );
        try{
            user = restTemplate.getForObject( baseURL + "/UserDetails/"+ id, User.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }

}