import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutTest {

    @Test
    void logoutWithValidToken() {

        String baseUrl = "https://api.rizqifauzan.com";
        String token = "eb8f35b9-677b-4730-9d19-049449f23a6c";

        Response response = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + token)
                .post("/api/auth/logout");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        assertEquals(200, response.getStatusCode());
        assertTrue(response.jsonPath().getBoolean("success"));
        assertEquals(
                "Logout berhasil",
                response.jsonPath().getString("message")
        );
    }
}