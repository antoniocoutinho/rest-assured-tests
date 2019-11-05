package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class RestAssuredWithTestNG {

    @DataProvider(name="seasonsAndNumberOfRaces")
    public Object[][] testDatarecords(){

        return new Object[][] {
                {"2017", 20},
                {"2016", 21},
                {"1966", 9}
        };
    }
    @Test(dataProvider = "seasonsAndNumberOfRaces")
    public void testUsingDataProvider(String season, int qtd){

        given().
            pathParam("raceSeason", season).
        when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
        then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(qtd));



    }
}
