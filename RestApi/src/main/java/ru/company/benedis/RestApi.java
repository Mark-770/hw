package ru.company.benedis;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class RestApi {

    static String rapidapi_host = "wft-geo-db.p.rapidapi.com";
    static String rapidapi_key = "44c6daf8a0msh755e097596fe272p1cfd2fjsn7256b2462e62";


    @Test
    public void Locales() throws InterruptedException {
        given().
                header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com").
                header("x-rapidapi-key", "44c6daf8a0msh755e097596fe272p1cfd2fjsn7256b2462e62").
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/locales").
                then().
                assertThat().
                body("metadata.totalCount", equalTo(772));
        Thread.sleep(500);


    }

    @Test
    public void Currencies() throws InterruptedException {
        given().
                header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com").
                header("x-rapidapi-key", "44c6daf8a0msh755e097596fe272p1cfd2fjsn7256b2462e62").
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/currencies").
                then().
                assertThat().
                body("data[1].countryCodes", hasSize(1)).
                body("links[2].href", equalTo("/v1/locale/currencies?offset=200&limit=5"));
        Thread.sleep(500);
    }


    @Test
    public void Timezones() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/timezones").
                then().
                assertThat().
                body("data[4].name", equalTo("East Africa Time")).
                body("data[4].rawUtcOffsetHours", equalTo(3));
        Thread.sleep(500);
    }

    @Test
    public void Cities() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/geo/cities").
                then().
                assertThat().
                statusCode(200).
                body("data", hasSize(5)).
                body("data[1].id",equalTo(866)).
                body("data[1].name",equalTo("Arinsal")).
                body("data[1].country",equalTo("Andorra"));
        Thread.sleep(500);
    }
//
    @Test
    public void Countries() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/geo/countries").
                then().
                assertThat().
                body("data[0].code", equalTo("VA")).
                body("data[0].name", equalTo("Vatican City")).
                body("data[0].wikiDataId", not( emptyString()));
        Thread.sleep(500);
    }
}