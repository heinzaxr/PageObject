package example;

import filter.OAuth2Filter;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestAssuredTest {

    @BeforeAll
    public static void setUpRestAssuredConfiguration() {
        RestAssured.baseURI = "https://api.github.com/";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new OAuth2Filter());
    }

    @Test
    public void authTest() {
        String descriptionOld = given()
                .when()
                .get("user/repos")
                .then()
                .statusCode(200)
                .extract()
                .path("description[0]");

        given()
                .body("{\"description\": \"RestAssured example lessons Old\"}")
                .when()
                .patch("repos/dvkashin1/lessons")
                .then()
                .statusCode(200);

        String descriptionNew = given()
                .when()
                .get("user/repos")
                .then()
                .statusCode(200)
                .extract()
                .path("description[0]");

        assertThat(descriptionOld, not(descriptionNew));
    }

}
