package com.eci.round.connection;

import com.eci.round.loadBalance.RoundRobinLoadBalancer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    private static final String USER_AGENT = "Mozilla/5.0";

    RoundRobinLoadBalancer roundRobin;
    public HttpConnection(){
        roundRobin = new RoundRobinLoadBalancer();
    }
    public String getLogServiceData(String cadena) throws IOException {
        System.out.println("Cadenaaaaaa"+cadena);
        String round = roundRobin.getIp();
        System.out.println("This is my round:  "+round);
        String apiURL = round +"/log?cadena="+cadena;

        URL obj = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the com.eci.round.connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "{Error}";
    }

    public void addLogService(String cadena){

    }
}
