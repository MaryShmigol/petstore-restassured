import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetStoreTests {
    final static PetEndPoint PET_ENDPOINT = new PetEndPoint();

    @Test
    public void getPetById200() {
        PET_ENDPOINT
                .getPetById(1)
                .then().statusCode(200);
    }

    @Test
    public void getPetById() {
        PET_ENDPOINT
                .getPetById(0)
                .then()
                .statusCode(404);
    }
    @Test
    public void getPetByStatus(){
        PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .statusCode(200);
}
    @Test
    public void createPet(){
        String body = "{\n" +
                "  \"id\": 123,\n" +
                "  \"category\": {\n" +
                "    \"id\": 123,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"cat\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        PET_ENDPOINT.createPet(body)
                .then()
                .statusCode(200);
    }
}
