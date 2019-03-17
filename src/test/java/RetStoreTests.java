import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RetStoreTests {
    @Test
    public void getPetById200() {
     RestAssured
                .given().baseUri(Config.PET_STORE_BASE_HOST)
                .basePath("/pet/1")
                .log().uri()
                .get()
                .then()
                .statusCode(200);

    }

    @Test
    public void getPetById() {
        RestAssured
                .given().baseUri(Config.PET_STORE_BASE_HOST)
                .get()
                .then()
                .statusCode(404);
    }
}
