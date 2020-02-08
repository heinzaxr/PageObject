package spec;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MixedSpecificationTest {

    @Test
    public void mixedSpecTest() {
        RequestSpecification firstRequestSpecification = given()
                .baseUri("https://api.github.com/")
                .header("RequestSpecification", "first");

        RequestSpecification secondRequestSpecification = given()
                .header("RequestSpecification", "second");

        given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .spec(firstRequestSpecification)
                .spec(secondRequestSpecification)
                .when()
                .get("")
                .then()
                .statusCode(200);
    }

}
