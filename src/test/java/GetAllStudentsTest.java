import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetAllStudentsTest {

    @Test
    void getAllStudentsWithValidToken() {

        String baseUrl = "https://api.rizqifauzan.com";

        String token = AuthHelper.getValidToken();

        Response response = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + token)
                .get("/api/siswa?page=1&limit=10");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        assertEquals(200, response.getStatusCode());
        assertTrue(response.jsonPath().getBoolean("success"));

        assertNotNull(response.jsonPath().getList("data.data"));
        assertFalse(response.jsonPath().getList("data.data").isEmpty());

        assertEquals(1, response.jsonPath().getInt("data.pagination.page"));
        assertEquals(10, response.jsonPath().getInt("data.pagination.limit"));

        int total = response.jsonPath().getInt("data.pagination.total");
        int totalPages = response.jsonPath().getInt("data.pagination.totalPages");

        assertTrue(total > 0);
        assertTrue(totalPages > 0);
    }
}