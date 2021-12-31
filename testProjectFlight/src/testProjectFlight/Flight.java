package testProjectFlight;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Flight {

    // Requesting an HTTP Request;
    public static void main(String[] args) {
        // Https Request using java.net.HttpURLConnection
        HttpURLConnection connection;
        BufferedReader reader;
        String Line;
        StringBuilder responseContent = new StringBuilder(); // the type can be StringBuffer;

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            connection = (HttpURLConnection) url.openConnection();

            // Request Setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); //5000 milli seconds
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
//            System.out.println(status);
//            System.out.println(responseContent.toString());

//            parse(responseContent.toString());

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((Line = reader.readLine()) != null) {
                    responseContent.append(Line);
                }
                reader.close();
            }
            else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((Line = reader.readLine()) != null) {
                    responseContent.append(Line);
                }
                reader.close();
            }

            String s = responseContent.toString();
            parse(s);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void parse(String content) {
        try {
            JSONArray albums = new JSONArray(content);
            for (int i = 0; i < albums.length(); i ++) {
                JSONObject album = albums.getJSONObject(i);
                int id = album.getInt("id");
                int userId = album.getInt("userId");
                String title = album.getString("title");
                System.out.println(id + " "  + title + " " + userId );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


//    public static void parse(String response) {
//        JSONParser parser = new JSONParser();
//        try {
//            Object obj = parser.parse(response);
//            JSONArray albumsArray = (JSONArray) obj;
////            for (int i = 0; i < albumsArray.; i ++) {
////                JSONObject album = albumsArray.getJSONObject(i);
////                int id = album.getInt("id");
////                int userId = album.getInt("userId");
////                String title = album.getString("title");
////                System.out.println(id + " "  + title + " " + userId );
////            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void parse(String response) {
//        // parsing file "JSONExample.json"
//        try {
//            Object ob = new
//
//            // typecasting ob to JSONObject
//            JSONArray albumsArray = (JSONArray) ob;
//            for (int i = 0; i < albumsArray.size(); i ++) {
////                JSONObject albumsObject = (JSONObject) albumsArray.get(i);
////                System.out.println(albumsArray.get(i).getClass());
//
//                Object jsO = new JSONParser().parse(response);
//
//                JSONObject js = (JSONObject) jsO;
//                String firstName = (String) js.getString("id");
//
//                System.out.println(firstName);
//            }
//        } catch (ParseException | JSONException e) {
//            e.printStackTrace();
//        }
//
//    }


}