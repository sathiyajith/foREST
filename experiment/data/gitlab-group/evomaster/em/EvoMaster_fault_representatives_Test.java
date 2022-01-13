import  org.junit.AfterClass;
import  org.junit.BeforeClass;
import  org.junit.Before;
import  org.junit.Test;
import static org.junit.Assert.*;
import  java.util.Map;
import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import  io.restassured.response.ValidatableResponse;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import  org.evomaster.client.java.controller.SutHandler;
import static org.evomaster.client.java.controller.db.dsl.SqlDsl.sql;
import  org.evomaster.client.java.controller.api.dto.database.operations.InsertionResultsDto;
import  org.evomaster.client.java.controller.api.dto.database.operations.InsertionDto;
import  java.util.List;
import static org.hamcrest.Matchers.*;
import  io.restassured.config.JsonConfig;
import  io.restassured.path.json.config.JsonPathConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.evomaster.client.java.controller.contentMatchers.NumberMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.StringMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.SubStringMatcher.*;
import static org.evomaster.client.java.controller.expect.ExpectationHandler.expectationHandler;
import  org.evomaster.client.java.controller.expect.ExpectationHandler;
import  io.restassured.path.json.JsonPath;
import  java.util.Arrays;




/**
 * This file was automatically generated by EvoMaster on 2022-01-13T00:37:23.513822300+08:00[Asia/Shanghai]
 * <br>
 * The generated test suite contains 2 tests
 * <br>
 * Covered targets: 6
 * <br>
 * Used time: 6h 0m 0s
 * <br>
 * Needed budget for current results: 99%
 * <br>
 * This file contains one example of each category of fault. The test cases in this file are a subset of the set of test cases likely to indicate faults.
 */
public class EvoMaster_fault_representatives_Test {

    
    private static String baseUrlOfSut = "http://192.168.112.186";
    /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
    * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
    */
    private static boolean ems = false;
    /**
    * sco - supported code oracle - checking that the response status code is among those supported according to the schema
    */
    private static boolean sco = false;
    
    
    @BeforeClass
    public static void initClass() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;
        RestAssured.config = RestAssured.config()
            .jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE))
            .redirect(redirectConfig().followRedirects(false));
    }
    
    
    
    
    
    
    
    
    /**
    * [test_0_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    */
    @Test
    public void test_0_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("Authorization", "Bearer TS2zsbuMVNmtjf3P3Cwx") // Fixed Headers
                .header("a", "a") // Fixed Headers
                .header("b", "b") // Fixed Headers
                .get(baseUrlOfSut + "/api/v4/groups?" + 
                    "skip_groups=%5B%5D&" + 
                    "all_available=false&" + 
                    "search=qzHpw9ic35lw&" + 
                    "statistics=true&" + 
                    "with_custom_attributes=true")
                .then()
                .statusCode(500)
                .assertThat()
                .contentType("application/json")
                .body("'message'", containsString("500 Internal Server Error"));
        
        expectationHandler.expect(ems)
            /*
             Note: No supported codes appear to be defined. https://swagger.io/docs/specification/describing-responses/.
             This is somewhat unexpected, so the code below is likely to lead to a failed expectation
            */
            .that(sco, Arrays.asList().contains(res_0.extract().statusCode()));
    }
    
    
    @Test
    public void test_1() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Bearer TS2zsbuMVNmtjf3P3Cwx") // Fixed Headers
                .header("a", "a") // Fixed Headers
                .header("b", "b") // Fixed Headers
                .contentType("application/json")
                .body(" { " + 
                    " \"expires_at\": \"QN1eoNmFn\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v4/groups/541/share?" + 
                    "group_id=902&" + 
                    "group_access=94")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'error'", containsString("group_access does not have a valid value, expires_at is invalid"));
        
        expectationHandler.expect(ems)
            /*
             Note: No supported codes appear to be defined. https://swagger.io/docs/specification/describing-responses/.
             This is somewhat unexpected, so the code below is likely to lead to a failed expectation
            */
            .that(sco, Arrays.asList().contains(res_0.extract().statusCode()));
    }


}
