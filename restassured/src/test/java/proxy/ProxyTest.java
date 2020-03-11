package proxy;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ProxyTest {

    @BeforeAll
    public static void setUpProxy() {
        RestAssured.proxy("localhost", 8888);
    }

    // OR

    @Test
    public void givenWhenThenTest() {
        given().proxy("localhost", 8888)
                .when()
                .get("https://api.github.com/")
                .then()
                .statusCode(200);
    }

}
