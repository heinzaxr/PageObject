package spec;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationTest {

    @Test
    public void reqSpecTest() {
        RequestSpecification requestSpec = given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .baseUri("https://api.github.com/repos/")
                .pathParam("owner", "Selenide")
                .pathParam("repos", "Selenide")
                .queryParam("state", "closed");

        given()
                .spec(requestSpec)
                .when()
                .get("{owner}/{repos}/issues")
                .then()
                .statusCode(200);
    }

}
