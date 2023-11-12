package Pages;

import io.restassured.http.ContentType;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BoardPages {
    String boardId;
    public void createBoard(){
        String boardId=given()
                .contentType("application/json").
                when()
                .queryParam("key", ConfigurationReader.getProperty("key"))
                .queryParam("token", ConfigurationReader.getProperty("token"))
                .queryParam("name", "BoardTest")
                .post("/boards").
                then()
                .statusCode(200)
                .contentType(ContentType.JSON).
                assertThat()
                .body("name", equalTo("BoardTest"))
                .extract().path("id");

        this.boardId=boardId;
    }
    public void deleteBoard() {

        given()
                .contentType("application/json").
                when()
                .queryParam("key", ConfigurationReader.getProperty("key"))
                .queryParam("token", ConfigurationReader.getProperty("token"))
                .delete("/boards/"+boardId).
                then()
                .statusCode(200);
    }

    public String getBoardId() {
        return boardId;
    }
}
