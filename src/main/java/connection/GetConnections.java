/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author jarmo
 */
public class GetConnections {

    public GetConnections() {
    }
    
    //Method for the most basic query with three parameters
    //The arguments in the method come through the rest api
    public String GetWithThree(String origin, String date, int tickets) {
    
        try {
                //Connection string for now to lars's airline, final product in list
		URL url = new URL("http://airline-plaul.rhcloud.com/api/flightinfo/" + origin 
                        + "/" + date + "/" + tickets);
                //Creating the connection
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //Specifying the request type
		conn.setRequestMethod("GET");
                //Setting correct headers
		conn.setRequestProperty("Accept", "application/json");
                //Checking if the server is available
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                //Getting the actual input from the external server
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
                //Storing the server inbound 
		output = br.readLine();
			
                //Kill the connection
		conn.disconnect();
                //Final return, is a string
                return output;

	  } catch (MalformedURLException e) {

                return "error occured " + e;

	  } catch (IOException e) {

                return "error occured " + e;

	  }
        
        
          
	}
}
        
       
    



