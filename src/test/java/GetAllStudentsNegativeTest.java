import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetAllStudentsNegativeTest {

    @Test
    void getAllStudentsWithoutToken() {

        String baseUrl = "https://api.rizqifauzan.com";

        Response response = RestAssured
                .given()
                .baseUri(baseUrl)
                .get("/api/siswa?page=1&limit=10");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        assertEquals(401, response.getStatusCode());
        assertFalse(response.jsonPath().getBoolean("success"));
        assertEquals("Unauthorized - Token tidak ditemukan", response.jsonPath().getString("error"));
    }
}