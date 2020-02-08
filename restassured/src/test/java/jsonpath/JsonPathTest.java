package jsonpath;

import filter.OAuth2Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsonPathTest {

    @Test
    public void pathExtractTest() {
        String issuesUrl = given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new OAuth2Filter())
                .when()
                .get("https://api.github.com/")
                .then()
                .statusCode(200)
                .extract()
                .path("issues_url");

        assertThat(issuesUrl, is("https://api.github.com/issues"));
    }

    @Test
    public void jsonPathExtractTest() {
        JsonPath jsonPath = given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new OAuth2Filter())
                .when()
                .get("https://api.github.com/")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();

        String issuesUrl = jsonPath.getString("issues_url");
        assertThat(issuesUrl, is("https://api.github.com/issues"));
    }

    @Test
    public void pathTest() {
        given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new OAuth2Filter())
                .when()
                .get("https://api.github.com/")
                .then()
                .statusCode(200)
                .body("issues_url", is("https://api.github.com/issues"));
    }

}
