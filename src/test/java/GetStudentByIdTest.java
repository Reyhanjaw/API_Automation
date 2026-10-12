import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetStudentByIdTest {

    @Test
    void getStudentByIdWithValidToken() {

        String baseUrl = "https://api.rizqifauzan.com";

        // 1. Login dan mendapatkan token
        String token = AuthHelper.getValidToken();

        // 2. Get list students
        Response studentsResponse = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + token)
                .get("/api/siswa?page=1&limit=10");

        // 3. Pastikan request Get All Students berhasil
        assertEquals(200, studentsResponse.getStatusCode());
        assertTrue(studentsResponse.jsonPath().getBoolean("success"));

        // 4. Ambil ID siswa pertama secara otomatis
        String studentId = studentsResponse
                .jsonPath()
                .getString("data.data[0].id");

        System.out.println("Student ID: " + studentId);

        assertNotNull(studentId);
        assertFalse(studentId.isEmpty());

        // 5. Get student berdasarkan ID
        Response studentResponse = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + token)
                .get("/api/siswa/" + studentId);

        System.out.println("Status Code: " + studentResponse.getStatusCode());
        System.out.println("Response: " + studentResponse.asString());

        // 6. Validasi response
        assertEquals(200, studentResponse.getStatusCode());
        assertTrue(studentResponse.jsonPath().getBoolean("success"));

        // 7. Pastikan ID pada response sesuai dengan ID yang kita request
        assertEquals(
                studentId,
                studentResponse.jsonPath().getString("data.id")
        );
    }
}