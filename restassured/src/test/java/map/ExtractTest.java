package map;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExtractTest {

    @Test
    public void extractAsClassTest() {
        GithubApiUrl githubApiUrl = given()
                .when()
                .get("https://api.github.com/")
                .then()
                .statusCode(200)
                .extract()
                .as(GithubApiUrl.class);

        assertThat(githubApiUrl.events_url, is("https://api.github.com/events"));
        assertThat(githubApiUrl.feeds_url, is("https://api.github.com/feeds"));
    }

}
