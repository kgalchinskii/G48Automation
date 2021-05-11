package tests.api.NovaPoshta;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import tests.api.BaseApiTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.internal.matcher.xml.XmlXsdMatcher.matchesXsd;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class NpGetTimeIntervalsTest extends BaseApiTest {

    ContentType contentType;
    Object body;
    String pathFormat;
    Matcher<?> bodySchema;

    public NpGetTimeIntervalsTest(ContentType contentType, Object body, String pathFormat, Matcher<?> bodySchema) {
        this.contentType = contentType;
        this.body = body;
        this.pathFormat = pathFormat;
        this.bodySchema = bodySchema;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() throws JsonProcessingException {
        List<Object[]> result = new ArrayList<>();
        result.add(new Object[]{ContentType.JSON, bodyJson(), "/json", matchesJsonSchema(
                new File(getProperty("user.dir")
                        + "\\src\\test\\resources\\jsonSchema\\intervals.json"))});
        result.add(new Object[]{ContentType.XML, bodyXML(), "/xml", matchesXsd(
                new File(getProperty("user.dir")
                        + "\\src\\test\\resources\\xmlSchema\\intervals.xsd"))});
        return result;
    }

    public static Object bodyJson() {
        Map<String, Object> body = new HashMap<>();
        Map<String, Object> methodProperties = new HashMap<>();
        methodProperties.put("RecipientCityRef", "8d5a980d-391c-11dd-90d9-001a92567626");
        methodProperties.put("DateTime", "18.09.2021");
        body.put("apiKey", "");
        body.put("modelName", "Common");
        body.put("calledMethod", "getTimeIntervals");
        body.put("methodProperties", methodProperties);
        return body;
    }

    public static Object bodyXML() throws JsonProcessingException {
        Map<String, Object> body = new HashMap<>();
        Map<String, Object> methodProperties = new HashMap<>();
        methodProperties.put("RecipientCityRef", "8d5a980d-391c-11dd-90d9-001a92567626");
        methodProperties.put("DateTime", "18.09.2021");
        body.put("apiKey", "");
        body.put("modelName", "Common");
        body.put("calledMethod", "getTimeIntervals");
        body.put("methodProperties", methodProperties);
        return new XmlMapper().writeValueAsString(body);
    }

    @Owner("Galchinskij")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("NP-2")
    @Description("Check time intervals")
    @Stories({
            @Story("NovaPoshta"),
            @Story("")
    })
    @Feature("Time intervals")
    @Issues({
            @Issue(""),
            @Issue("")
    })
    @DisplayName("")
    @Test
    public void getTimeIntervals() {
        given().spec(this.rspec)
                .baseUri("https://api.novaposhta.ua/v2.0")
                .contentType(contentType)
                .body(body)
                .when()
                .log().all()
                .post(pathFormat + "/common/getTimeIntervals/")
                .then()
                .log().all()
                .spec(respSpec)
                .assertThat()
                .statusCode(200)
                .body(bodySchema);
    }

}
