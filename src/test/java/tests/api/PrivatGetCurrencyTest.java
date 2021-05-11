package tests.api;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@RunWith(Parameterized.class)
public class PrivatGetCurrencyTest extends BaseApiTest {

    private final int courseId;

    public PrivatGetCurrencyTest(int courseId) {
        this.courseId = courseId;
    }

    @Parameterized.Parameters
    public static List<Integer> data() {
        return new ArrayList<Integer>() {{
            add(5);
            add(11);
        }};
    }

    @Owner("Galchinskij")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PB-1")
    @Description("Check get currency")
    @Stories({
            @Story("PrivatBank"),
            @Story("")
    })
    @Feature("Currency")
    @Issues({
            @Issue(""),
            @Issue("")
    })
    @DisplayName("")
    @Test
    public void checkCurrencyInPB() {
        given().spec(rspec)
                .baseUri("https://api.privatbank.ua/p24api")
                .queryParam("json")
                .queryParam("exchange")
                .queryParam("coursid", this.courseId)
                .relaxedHTTPSValidation()
                .when()
                .log()
                .everything()
                .get("/pubinfo")
                .then()
                .log()
                .everything()
                .spec(respSpec)
                .assertThat()
                .body("ccy", hasItems("USD", "EUR", "BTC", "RUR"))
                .body("ccy", hasSize(4))
                .body("base_ccy", hasItem(equalTo("UAH")));
    }

}