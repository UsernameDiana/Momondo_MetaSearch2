package connection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class URLConnection {

    private final String origin = "";
    private final String date = "";
    private final String flightID = "";
    private static List<String> urls ;
    
    public static void main(String[] args) throws Exception {

        URLConnection http = new URLConnection();
        
        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

        System.out.println("\nTesting 2 - Send Http POST request");
        http.sendPost();       
    }

    // Send an HTTP GET request to momondo.com to get the search result.
    private void sendGet() throws Exception {

       //added two links o the list
       // urls.add("http://airline-plaul.rhcloud.com/#/links");  
       // urls.add("Dummy airline");
        String url = "http://airline-plaul.rhcloud.com/#/links"; // url for Lars dummyAirline
        // we migth want to mouve this out side the method, so we can call  
        // this method on every url Dummy, Lars's, other groups.

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        //add request header, @PATH in REST --  What we are searching for.
        con.setRequestProperty("origin", origin);
        con.setRequestProperty("date", date);

        String responseMessage = con.getResponseMessage(); // was con.getResponseCode before
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response message : " + responseMessage);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    }

    // Send an HTTP POST request to Lars dummy airline search form to check the flight detail
    private void sendPost() throws Exception {

        String url = "http://airline-plaul.rhcloud.com/#/links"; //Lars dummy airline
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("flightID", flightID);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = ""; // ????????????

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        String responseMessage = con.getResponseMessage();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response message : " + responseMessage);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
