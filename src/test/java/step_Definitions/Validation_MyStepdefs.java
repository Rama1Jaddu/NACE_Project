package step_Definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class Validation_MyStepdefs {

    @Given("^perform GET operation for \"([^\"]*)\"$")
    public void performGETOperationFor(String arg0) throws Throwable {
        given().contentType(ContentType.JSON);
    }

    @And("^perform getNACEDetails for the order number \"([^\"]*)\"$")
    public void performGetNACEDetailsForTheOrderNumber(String arg0) throws Throwable {
        when().get(String.format("https://ec.europa.eu/eurostat/ramon/nomenclatures/index.cfm?TargetUrl=LST_CLS_DLD&amp;StrNom=NACE_REV2&amp;StrLanguage&amp;Order=3981481"
                )).then().statusCode(HttpStatus.SC_OK);


    }

    @Then("^validate the response as \"([^\"]*)\"$")
    public void validateTheResponseAs(String arg0) throws Throwable {
        when().get(String.format("https://ec.europa.eu/eurostat/ramon/nomenclatures/index.cfm?TargetUrl=LST_CLS_DLD&amp;StrNom=NACE_REV2&amp;StrLanguage&amp;Order=3981481"
        )).then().assertThat().body("Order", is("398481"));
                //(matchesJsonSchemaInClasspath("schema.json")).statusCode(200).body()//("Order","398481");
    }
}
