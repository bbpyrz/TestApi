package Pages;

import io.restassured.http.ContentType;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CardPages {
    String cardIds[]=new String[2];
    public void createTwoCards(String listId){

        for (int i = 0; i < 2; i++) {
            this.cardIds[i] = given()
                    .contentType("application/json").
                    when()
                    .queryParam("key", ConfigurationReader.getProperty("key"))
                    .queryParam("token", ConfigurationReader.getProperty("token"))
                    .queryParam("name","newCard"+i)
                    .queryParam("idList",listId)
                    .queryParam("desc","initial Test Description")
                    .post("/cards").
                    then()
                    .statusCode(200)
                    .contentType(ContentType.JSON).
                    assertThat()
                    .body("name", equalTo("newCard"+i))
                    .extract().path("id");
        }

    }
    public void editCards(){
        double random= Math.random()*2;
        int index= (int) Math.nextDown(random);
        given()
                .contentType("application/json").
                when()
                .queryParam("key", ConfigurationReader.getProperty("key"))
                .queryParam("token", ConfigurationReader.getProperty("token"))
                .queryParam("name","newCard0")
                .queryParam("desc","edited Test Description")
                .put("/cards/"+cardIds[index]).
                then()
                .statusCode(200)
                .contentType(ContentType.JSON).
                assertThat()
                .body("desc", equalTo("edited Test Description"))
                .extract().path("id");

    }
    public void deleteCards() {
        for(int i=0;i< cardIds.length;i++){
            given()
                    .contentType("application/json").
                    when()
                    .queryParam("key", ConfigurationReader.getProperty("key"))
                    .queryParam("token", ConfigurationReader.getProperty("token"))
                    .delete("/cards/"+cardIds[i]).
                    then()
                    .statusCode(200);
        }
    }
}
