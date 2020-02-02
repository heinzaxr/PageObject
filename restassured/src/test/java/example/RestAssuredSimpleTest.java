package example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestAssuredSimpleTest {

    @Test
    public void givenWhenThenTest() {
        given()
                .when()
                .get("https://api.github.com/")
                .then()
                .statusCode(200);
    }

    @Test
    public void responseTest() {
        Response response = RestAssured.get("https://api.github.com/");
        assertThat(response.statusCode(), is(200));
    }

}