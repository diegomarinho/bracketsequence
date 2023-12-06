package br.com.bravi.bracketsequence.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestPropertySource(
        properties = {
                "spring.main.allow-bean-definition-overriding=true",
                "server.servlet.context-path=/"
        })
class BracketControllerTest {

    private static final String URL = "http://localhost";
    private static final String PATH = "/api/bracket/validate";

    @LocalServerPort
    private int port;

    //@Test
    public void testSaveBracketSequence_ValidSequence_ReturnsCreated() {
        RestAssured.baseURI = URL;
        RestAssured.port = port;

        String validSequence = "{()}{}";

        given()
                .contentType(ContentType.JSON)
                .body("{\"sequence\": \"" + validSequence + "\"}")
        .when()
                .post(PATH)
        .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("message", containsString("A sequência de colchetes é válida"));
    }

    //@Test
    public void testSaveBracketSequence_InvalidSequence_ReturnsBadRequest0() {
        RestAssured.baseURI = URL;
        RestAssured.port = port;

        String invalidSequence = "[";

        given()
                .contentType(ContentType.JSON)
                .body("{\"sequence\": \"" + invalidSequence + "\"}")
        .when()
                .post(PATH)
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .contentType(ContentType.JSON)
                .body("message", containsString("A sequência de colchetes não é válida"));
    }
}

