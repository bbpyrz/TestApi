package Pages;

import io.restassured.http.ContentType;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ListPages{

    String listId;

    public String getListId(){
        return listId;
    }
    public void createListAndGetId(String boardId){

        String listId=given()
                .contentType("application/json")
                .when()
                .queryParam("key", ConfigurationReader.getProperty("key"))
                .queryParam("token", ConfigurationReader.getProperty("token"))
                .queryParam("name","ListTest")
                .post("/boards/"+boardId+"/lists")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body("name", equalTo("ListTest"))
                .extract().path("id");
        this.listId=listId;
    }

}
