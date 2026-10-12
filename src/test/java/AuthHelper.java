import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class AuthHelper {

    public static String getValidToken() {

        String baseUrl = "https://api.rizqifauzan.com";

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "mrjreyhan@gmail.com");
        requestBody.put("password", "Jepara111!");

        Response response = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post("/api/auth/login");

        return response.jsonPath().getString("data.token");
    }
}