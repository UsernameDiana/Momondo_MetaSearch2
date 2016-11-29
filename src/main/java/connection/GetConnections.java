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
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jarmo
 */
public class GetConnections {

    public GetConnections() {
    }

    public List<String> FourParameterConnection(String origin, String destination, String date, int tickets) throws ProtocolException, MalformedURLException, IOException {
        
    
//            String t = Integer.toString(tickets);
            //Connection string for now to lars's airline, final product in list
            URL url = new URL("http://airline-plaul.rhcloud.com/api/flightinfo/" 
                    + origin + "/" + destination + "/" + date + "/" + tickets);
            
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
            List<String> finalOutput = new ArrayList<>();
            
            //Storing the server inbound 
            while ((output = br.readLine()) != null) {
                response.append(output);
                finalOutput.add(output);
            }
            
            System.out.println("Output from Server .... \n");

            System.out.println("Result for threeparameters: " + response);

            //Kill the connection
            conn.disconnect();

            //Final return, is a string
            System.out.println("Final thing for threeparameters:" + response);
            for (String s : finalOutput) {
                System.out.println(s);
        }
            return finalOutput;

        } 
    
    public List<String> ThreeParameterConnection(String origin, String date, int tickets) throws ProtocolException, IOException {
    
            String t = Integer.toString(tickets);
            //Connection string for now to lars's airline, final product in list
            URL url = new URL("http://airline-plaul.rhcloud.com/api/flightinfo/" 
                    + origin + "/" + date + "/" + t);
            
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
            List<String> finalOutput = new ArrayList<>();
            
            //Storing the server inbound 
            while ((output = br.readLine()) != null) {
                response.append(output);
                finalOutput.add(output);
            }
            
            System.out.println("Output from Server .... \n");

            System.out.println("Result for threeparameters: " + response);

            //Kill the connection
            conn.disconnect();

            //Final return, is a string
            System.out.println("Final thing for threeparameters:" + response);
            for (String s : finalOutput) {
                System.out.println(s);
        }
            return finalOutput;

        } 
    
//    public static void main(String[] args) {
//     ThreeParameterConnection("CPH", "2017-01-23T00:00:00.000Z", 1);   
//     FourParameterConnection();
//    }

}
