import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StubTest {

    @Test
    public void testMoscow() {
        WireMockServer wireMockServer = new WireMockServer(new WireMockConfiguration().port(9090));
        wireMockServer.start();

        wireMockServer.stubFor(get(urlEqualTo("/moscow"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("{\"city\":\"Moscow\",\"greeting\":\"Good morning\"}")));

        Response response = given()
                .when()
                .get("http://localhost:9090/moscow")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String city = response.jsonPath().get("city");
        String greeting = response.jsonPath().get("greeting");

        assertThat(city, is("Moscow"));
        assertThat(greeting, is("Good morning"));

        System.out.println(greeting + " " + city);
        wireMockServer.stop();
    }


    @Test
    public void testLondon() {
        WireMockServer wireMockServer = new WireMockServer(new WireMockConfiguration().port(9090));
        wireMockServer.start();

        wireMockServer.stubFor(get(urlEqualTo("/london"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("{\"city\":\"London\",\"greeting\":\"Good evening\"}")));

        Response response = given()
                .when()
                .get("http://localhost:9090/london")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String city = response.jsonPath().get("city");
        String greeting = response.jsonPath().get("greeting");

        assertThat(city, is("London"));
        assertThat(greeting, is("Good evening"));

        System.out.println(greeting + " " + city);
        wireMockServer.stop();
    }

}