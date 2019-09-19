package ATMtrans.controller.bankInforController;

import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.factory.factoryBankInfor.BranchFactory;
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
public class BranchControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/User";

    @Test
    public void testGetAllUser() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET,entity,String.class);
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetBranchById(){
        Branch branch = restTemplate.getForObject( baseURL + "/branch/1", Branch.class);
        System.out.println(branch.getId());
        assertNotNull( branch );
    }

    @Test
    public void testCreateBranch(){
        Branch branch = BranchFactory.getName( "Blvl main road " );
        ResponseEntity<Branch> postResponse = restTemplate.postForEntity( baseURL +"/create",branch,Branch.class );
        assertNotNull( postResponse );
        assertNotNull( postResponse.getBody() );
    }

    @Test
    public void testUpdatedBranch(){
        int id = 1;
        Branch branch = restTemplate.getForObject( baseURL + "/branch/" + id, Branch.class );
        restTemplate.put( baseURL + "/AnotherBankName" + id, branch );
        Branch updatedBranch = restTemplate.getForObject( baseURL + "/branch/" + id, Branch.class );
        assertNotNull( updatedBranch );
    }


    @Test
    public void testDeleteUserDetails(){
        int id = 2;
        Branch branch = restTemplate.getForObject( baseURL + "/BranchId/" + id, Branch.class );
        assertNotNull( branch );
        restTemplate.delete( baseURL + "/branchs/" + id );
        try{
            branch = restTemplate.getForObject( baseURL + "/UserDetails/"+ id, Branch.class);
        }catch (final HttpClientErrorException e){
            assertEquals( e.getStatusCode(), HttpStatus.NOT_FOUND );
        }

    }
}