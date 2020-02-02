package filter;

import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.spi.AuthFilter;

public class OAuth2Filter implements AuthFilter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        requestSpec.replaceHeader("Authorization", "Bearer e45bc5c10e557551c93cfe8ae12867cc9b4baa05");
        return ctx.next(requestSpec, responseSpec);
    }

}
