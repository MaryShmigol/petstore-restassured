import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RetStoreTets {
    @Test
    public void getPetById200() {
        String response = RestAssured
                .given().baseUri("https://petstore.swagger.io/v2/pet/1")
                .log().uri()
                .get()
                .then()
                .statusCode(200)
                .and().extract().body().asString();
        System.out.println(response);
    }

    @Test
    public void getPetById() {
        RestAssured
                .given().baseUri("https://petstore.swagger.io/v2/pet/3")
                .get()
                .then()
                .statusCode(404);
    }
}
