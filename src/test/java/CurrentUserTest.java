import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentUserTest {

    @Test
    void getCurrentUserWithValidToken() {

        String baseUrl = "https://api.rizqifauzan.com";

        String token = AuthHelper.getValidToken();

        Response response = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + token)
                .get("/api/auth/me");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        assertEquals(200, response.getStatusCode());
        assertTrue(response.jsonPath().getBoolean("success"));
        assertNotNull(response.jsonPath().getString("data.id"));
        assertNotNull(response.jsonPath().getString("data.nama"));
        assertNotNull(response.jsonPath().getString("data.email"));
    }
}