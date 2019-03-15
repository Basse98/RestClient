import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {

    public static void main(String[] args) throws UnirestException {

        //Simple HTTP GET request
        HttpResponse<JsonNode> response = Unirest.get("http://httpbin.org/get").queryString("Limit",10).asJson();

        System.out.println(response.getBody().getObject().getString("url"));
        System.out.println(response.getBody().getObject().getJSONObject("headers").getString("Host"));


    }

}
