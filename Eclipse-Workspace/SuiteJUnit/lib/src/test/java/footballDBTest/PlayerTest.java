package footballDBTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.parallel.ExecutionMode;

public class PlayerTest {
	
	@ParameterizedTest(name = "{index} =>  {0} => {4}")
	@CsvFileSource(resources = "/FootballDBTest.csv", numLinesToSkip = 1, delimiter = ',')
	@Execution(ExecutionMode.CONCURRENT)
    public void GetPlayerNameTest(int id, String name) 
	{	
		System.out.println("GetPlayerNameTest: " + id);
        
		String url = "http://localhost:7000/FootballWeb/rs/FootballEJB/GetPlayerName?id=" + id;
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(url);
		Response response = base.request(MediaType.APPLICATION_JSON).get();
		String result = response.readEntity(String.class);
		
		assertEquals(name, result);
    }
}