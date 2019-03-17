import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws UnirestException {

        //Change URL to match your service

        //HTTP GET request
        HttpResponse<JsonNode> getResponse = Unirest.get("http://httpbin.org/get").queryString("Limit",10).asJson();

        System.out.println(getResponse.getBody().getObject().getString("url"));
        System.out.println(getResponse.getBody().getObject().getJSONObject("headers").getString("Host"));

        //Post Request with Json
        JSONObject exampleJson = new JSONObject().put("name","Oskar");
        exampleJson.put("age",21);
        exampleJson.put("id",4);
        HttpResponse<String> postResponse = Unirest.post("http://httpbin.org/post").body(exampleJson).asString();

        System.out.println(postResponse.getBody());

    }

}
