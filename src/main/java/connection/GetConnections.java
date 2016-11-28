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

    public static void main(String[] args) {
        
        try {
            
            //Connection string for now to lars's airline, final product in list
            URL url = new URL("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-01-30T00:00:00.000Z/1");
            
            //Creating the connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            //Specifying the request type
            conn.setRequestMethod("GET");
            
            //Setting correct headers
            conn.setRequestProperty("Accept", "application/json");
//                //Checking if the server is available
//		if (conn.getResponseCode() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : "
//					+ conn.getResponseCode());
//		}
            
            //Getting the actual input from the external server
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            StringBuffer response = new StringBuffer();

            //Storing the server inbound 
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            System.out.println("Output from Server .... \n");

            System.out.println("Result: " + response);

            //Kill the connection
            conn.disconnect();

            //Final return, is a string
            System.out.println("Final thing:" + response);

        } catch (MalformedURLException e) {

            System.out.println("error occured " + e);

        } catch (IOException e) {

            System.out.println("error occured " + e);

        }
    }

}
