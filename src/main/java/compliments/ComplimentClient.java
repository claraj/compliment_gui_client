package compliments;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;


public class ComplimentClient {
    
    private static final String SERVER_URL = "http://127.0.0.1:8080/";  // Replace with your URL
    private static final String TEXT = "text";  // key for reading JSON
    
    private static final String USER_ERROR_MSG = "<html>Sorry, an error happened. " +
            "<br>Good thing you are AWESOME at debugging!</html>";
    
    public static void getCompliment(final ComplimentGUI gui) {
        
        Unirest.get(SERVER_URL + "random")
                .header("accept", "application/json")
                .asJsonAsync(new Callback<JsonNode>() {
                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        JSONObject json = httpResponse.getBody().getObject();
                        gui.complimentMessage(json.getString(TEXT));
                    }
                    
                    public void failed(UnirestException e) {
                        gui.complimentMessage(USER_ERROR_MSG);
                    }
                    
                    public void cancelled() {
                        System.out.println("Request cancelled.");
                    }
                });
    }
}
    

    /*
    
    // The synchronous version. Fine for a command line program.
    
    public static String getCompliment() {
        
        try {
            HttpResponse<JsonNode> response = Unirest.get(SERVER_URL + "random")
                    .header("accept", "application/json")
                    .asJson();
            
            JSONObject jsonObject = response.getBody().getObject();
            return jsonObject.getString(TEXT);
            
        } catch (UnirestException e) {
            System.out.println(e);  // Just for debugging, if needed
            return USER_ERROR_MSG;
        }
    }
    
    */



