package filter;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FilterRestAssuredTest {

    @Test
    public void authTest() {
        given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new OAuth2Filter())
                .noFilters()
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200);
    }

}
