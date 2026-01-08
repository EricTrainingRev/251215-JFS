package com.revature.taskmanager.login;

import com.revature.taskmanager.entity.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

/*
    If you need your Spring web server to be up and running during your tests you will
    need to set the webEnvironment property of SpringBootTest. The default option is
    NONE, which means your web server will not be spun up during tests. If you want to
    use your default web server then set the value to DEFINED_PORT
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdminLoginTest {

    /*
        Junit will still be our test engine, but the actual steps within the test
        method will be handled by REST Assured. REST Assured uses a Given/When/Then
        syntax, just like Cucumber, to facilitate arranging, acting, and asserting
        test results. You can also configure global, or at least test collection, specific
        configurations
     */

    /*
        The RestAssured class provides multiple base configuration options, such as
        what your baseURI and port are
     */
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    /*
        You can also set test specific configurations that can change between test classes
     */
    @BeforeEach
    public void loginSetup(){
        RestAssured.basePath = "/login";
    }

    @Test
    public void adminLoginPositiveTest(){
        /*
            Once we have our configurations complete we can start arranging our test. To put together the data for
            the HTTP request you use the given() method and follow the builder design pattern to put together the
            meta data for the request
         */
        User credentials = new User();
        credentials.setUsername("admin");
        credentials.setPassword("admin");
        given()
                .contentType(ContentType.JSON)
                /*
                    if your project includes Jackson or GSON for data binding, you can provide an entity object to the
                    body method, and it will be converted into a JSON at test time. If you don't have these libraries
                    included in your project you will have to manually construct your json and pass it to the body method
                 */
                .body(credentials)
                // not needed for login, but showing as an example
                .header("Authorization", "token goes here")
        /*
            When you are ready to make your HTTP request you call when() and then call the method specific http request
            you want to make, such as post, get, put, etc. Make sure to include any remaining URL resource, such as the
            resource being interacted with, as part of the request
         */
        .when()
                .post("/admin") // only need /admin since http://localhost:8080/login is already include as part of the setup config
        /*
            After the request has been made we can start making our assertions: checking things like headers, response data,
            and status code, among other things
         */
        .then()
                // equivalent to statusCode == 200
                .statusCode(200)
                // checks there is a field in the response body called token that has a value
                .body("token", notNullValue());

    }

}
