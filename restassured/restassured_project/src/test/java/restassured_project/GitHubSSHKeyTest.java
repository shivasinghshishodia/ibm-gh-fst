package restassured_project;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubSSHKeyTest {

    private RequestSpecification requestSpec;

    // SSH public key to be added to GitHub
    private String sshKey =
            "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIEtxzwhyzsirLzTrO8ENW0bWvfKsz/+Pqx7C28SzaNyi";

    // ID generated after key creation
    private int keyId;

    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token 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")
                .build();
    }

    @Test(priority = 1)
    public void addSSHKey() {

        String requestBody = "{\n" +
                "    \"title\": \"TestAPIKey\",\n" +
                "    \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                given()
                        .spec(requestSpec)
                        .body(requestBody)
                .when()
                        .post("/user/keys")
                .then()
                        .extract()
                        .response();

        response.prettyPrint();

        keyId = response.jsonPath().getInt("id");

        assertEquals(response.getStatusCode(), 201,
                "Incorrect status code returned");

        assertNotNull(keyId, "SSH key ID should not be null");
    }

    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                .when()
                        .get("/user/keys/{keyId}")
                .then()
                        .extract()
                        .response();

        Reporter.log(response.asPrettyString(), true);

        assertEquals(response.getStatusCode(), 200,
                "Incorrect status code returned");

        assertEquals(response.jsonPath().getInt("id"),
                keyId,
                "Returned key ID does not match");
    }

    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                .when()
                        .delete("/user/keys/{keyId}")
                .then()
                        .extract()
                        .response();

        Reporter.log("Delete Response Status Code: "
                + response.getStatusCode(), true);

        assertEquals(response.getStatusCode(), 204,
                "Incorrect status code returned");
    }
}