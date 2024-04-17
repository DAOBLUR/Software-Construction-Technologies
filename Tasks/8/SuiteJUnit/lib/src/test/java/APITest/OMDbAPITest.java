package APITest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

public class OMDbAPITest {
	final String APIKey = "ac8a8a67";
	
	@Test
    public void TestTitle() 
	{
		String Title = "";
		
		String TitleExpected = "Thee Batman";
		
		Client client = ClientBuilder.newClient();
		String title = "Batman";
		int year = 2022;
		
		try 
		{
			Response response = client.target("http://www.omdbapi.com/?apikey=" + APIKey + "&t=" + title + "&y=" + year)
					.request(MediaType.APPLICATION_JSON)
					.get();
			
			if (response.getStatus() == 200) 
			{
				Map<String, Object> result = response.readEntity(new GenericType<Map<String, Object>>() {});
				Title =  (String) result.get("Title");
			} 
			else 
			{
				System.out.println("Error: " + response.getStatus());
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exception: " + e.toString());
		} 
		finally 
		{
			client.close();
		}

		assertEquals(TitleExpected, Title);
    }
	
	@Test
    public void TestDirector() 
	{
		String Director = "";
		
		String DirectorExpected = "Matt Reeves";
		
		Client client = ClientBuilder.newClient();
		String title = "Batman";
		int year = 2022;
		
		try 
		{
			Response response = client.target("http://www.omdbapi.com/?apikey=" + APIKey + "&t=" + title + "&y=" + year)
					.request(MediaType.APPLICATION_JSON)
					.get();
			
			if (response.getStatus() == 200) 
			{
				Map<String, Object> result = response.readEntity(new GenericType<Map<String, Object>>() {});
				Director =  (String) result.get("Director");
			} 
			else 
			{
				System.out.println("Error: " + response.getStatus());
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exception: " + e.toString());
		} 
		finally 
		{
			client.close();
		}

		assertEquals(DirectorExpected, Director);
    }
	
	@Test
    public void TestRuntime() 
	{
		String Runtime = "";
		
		String RuntimeExpected = "176 min";
		
		Client client = ClientBuilder.newClient();
		String title = "Batman";
		int year = 2022;
		
		try 
		{
			Response response = client.target("http://www.omdbapi.com/?apikey=" + APIKey + "&t=" + title + "&y=" + year)
					.request(MediaType.APPLICATION_JSON)
					.get();
			
			if (response.getStatus() == 200) 
			{
				Map<String, Object> result = response.readEntity(new GenericType<Map<String, Object>>() {});
				Runtime =  (String) result.get("Runtime");
			} 
			else 
			{
				System.out.println("Error: " + response.getStatus());
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exception: " + e.toString());
		} 
		finally 
		{
			client.close();
		}

		assertEquals(RuntimeExpected, Runtime);
    }
}