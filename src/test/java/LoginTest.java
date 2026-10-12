import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void loginWithValidAccount() {

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

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        assertEquals(200, response.getStatusCode());
        assertTrue(response.jsonPath().getBoolean("success"));
        assertNotNull(response.jsonPath().getString("data.token"));
    }

    @Test
    void loginWithInvalidAccount() {

        String baseUrl = "https://api.rizqifauzan.com";

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "mrjreyhan@gmail.com");
        requestBody.put("password", "Jepara1111!");

        Response response = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post("/api/auth/login");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        assertEquals(401, response.getStatusCode());
        assertFalse(response.jsonPath().getBoolean("success"));
        assertNull(response.jsonPath().getString("data.token"));
        assertEquals("Email atau password salah",
                response.jsonPath().getString("error")
        );
    }
}