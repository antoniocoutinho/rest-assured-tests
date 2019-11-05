package tests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTutorial {

    @Test
    public void testShouldCountQtdGPIn2017(){

        given().
        when().
                get("http://ergast.com/api/f1/2017/circuits.json").
        then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20)).
        and().
                statusCode(200).
        and().
                contentType(ContentType.JSON);
    }
    @Test
    public void checkMD5checkSunUsingQuaryParam(){

        String param = "test";
        String MD5 = "098f6bcd4621d373cade4e832627b4f6";

        given().
                param("text", param).
        when().
                get("http://md5.jsontest.com").
        then().
                assertThat().
                body("md5", equalTo(MD5));
    }
}
