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
        RestAssured.filters(new OAuth2Filter(), new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void authTest() {
        given()
                .body("{\"description\": \"RestAssured example lessons OLD\"}")
                .when()
                .patch("repos/dmitry-yarmush/javaqa-lessons")
                .then()
                .statusCode(200);

        String descriptionOld = getDescription();

        given()
                .body("{\"description\": \"RestAssured example lessons NEW\"}")
                .when()
                .patch("repos/dmitry-yarmush/javaqa-lessons")
                .then()
                .statusCode(200);

        String descriptionNew = getDescription();

        assertThat(descriptionOld, not(descriptionNew));
    }

    private String getDescription() {
        return given()
                .when()
                .get("user/repos")
                .then()
                .statusCode(200)
                .extract()
                .path("description[0]");
    }

}
