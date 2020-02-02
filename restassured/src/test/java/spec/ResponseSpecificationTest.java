package spec;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class ResponseSpecificationTest {

    @Test
    public void resSpecTest() {
        ResponseSpecification responseSpec = expect()
                .statusCode(200)
                .header("Server", "GitHub.com");

        given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .expect()
                .spec(responseSpec)
                .when()
                .get("https://api.github.com/repos/rest-assured/rest-assured/issues?state=open");
    }

}
