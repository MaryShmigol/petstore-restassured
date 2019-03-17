import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RetStoreTests {
    @Test
    public void getPetById200() {
        baseSpecification()
                .basePath(Config.GET_PET_ENDPOINT)
                .pathParam("id",1 )
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
    private RequestSpecification baseSpecification(){
        return RestAssured.given()
                   .baseUri(Config.PET_STORE_BASE_HOST)
                   .log().uri();
    }
}
