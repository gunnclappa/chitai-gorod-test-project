package chitaigorod.tests.api.specs;

import chitaigorod.config.AppConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static chitaigorod.helpers.AllureAttachments.withCustomTemplates;


public class Specification {

    private static final String URI = "https://www.chitai-gorod.ru";
    private static final String URI_WEB_API = "https://webapi.chitai-gorod.ru/web";

    private static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .addFilter(withCustomTemplates())
            .addCookie(AppConfigReader.Instance.read().cookieName(), AppConfigReader.Instance.read().cookieValue())
            .setBaseUri(URI)
            .log(LogDetail.METHOD)
            .log(LogDetail.URI)
            .build();

    public static RequestSpecification requestSpec() {
        return REQUEST_SPECIFICATION;
    }

    private static final RequestSpecification REQUEST_SPECIFICATION_WEB_API = new RequestSpecBuilder()
            .addFilter(withCustomTemplates())
            .addCookie(AppConfigReader.Instance.read().cookieName(), AppConfigReader.Instance.read().cookieValue())
            .setBaseUri(URI_WEB_API)
            .log(LogDetail.METHOD)
            .log(LogDetail.URI)
            .build();

    public static RequestSpecification requestSpecWebApi() {
        return REQUEST_SPECIFICATION_WEB_API;
    }

    private static final ResponseSpecification RESPONSE_SPECIFICATION = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .build();

    public static ResponseSpecification responseSpec() {
        return RESPONSE_SPECIFICATION;
    }
}
