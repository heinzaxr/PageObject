package spec;

import filter.OAuth2Filter;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BaseConfigurationTest {

    @BeforeAll
    public static void setUpRestAssuredConfiguration() {
        RestAssured.baseURI = "https://api.github.com/";
        RestAssured.filters(new OAuth2Filter(), new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void baseConfTest() {
        given()
                .when()
                .get("repos/dmitry-yarmush/javaqa-lessons")
                .then()
                .statusCode(200);
    }

}
