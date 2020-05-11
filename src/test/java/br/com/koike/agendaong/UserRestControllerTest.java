package br.com.koike.agendaong;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

@ContextConfiguration(classes = Application.class) 
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserRestControllerTest {


	  @Autowired
	  private TestRestTemplate restTemplate;

	  @LocalServerPort
	  private int port;

	  private String getRootUrl() {
	    return "http://localhost:" + port + "/api/v1";
	  }

	  @Test
	  public void contextLoads() {
	}

    
    
    @Test
    public void testGetAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/user",
            HttpMethod.GET, entity, String.class);

        Assert.notNull(response.getBody(), "Body is null!!");
    }
    

}
