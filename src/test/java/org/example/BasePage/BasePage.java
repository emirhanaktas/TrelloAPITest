package org.example.BasePage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.description.Description;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class BasePage extends Description {


    List<String> myList = Arrays.asList("CD2dA01aA6a74af9EE87BFA8", "0dd0d671DbcdEEad376f62Ae", "6bdBC1DFafd18FC90b03858f", "b3e9CBa4fEE1a5E04bd0b3C8", "c8AD36e328bccCdEFFB6bC85");

    Random r = new Random();

    int randomitem = r.nextInt(myList.size());
    String randomIdList = myList.get(randomitem);

    private String boardId = randomIdList;

    public String cardId1 = randomIdList;
    private String cardId2 = randomIdList;

    private String idList = randomIdList;

   public void pageCreateBoard(String object, String key, String token)
    {
        RestAssured.baseURI = "https://api.trello.com";
        Response response = given().log().all().queryParam("name", object)
                .queryParam("key", key)
                .queryParam("token", token)
                .contentType(ContentType.JSON)
                .when().post("/1/boards/");
                //then().log().all().assertThat().statusCode(200);
                assertEquals(HttpStatus.SC_OK, response.getStatusCode());

         JsonPath jsonPathEva = response.jsonPath();
            this.boardId =jsonPathEva.get("id");
            System.out.println(this.boardId);


    }

    public void pageCreateCard1(String idList, String key, String token, String nameObject)
    {
        RestAssured.baseURI = "https://api.trello.com";
        String idList2 = "6395f1e1ff0530006eb62e3b";
        Response response = given().log().all().queryParam(idList, idList2)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", nameObject)
                .contentType(ContentType.JSON)
                .when().post("1/cards/");
        //then().log().all().assertThat().statusCode(200);

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        JsonPath jsonPathEva = response.jsonPath();
        this.cardId1 =jsonPathEva.get("id");
        System.out.println(this.cardId1);
        this.idList = jsonPathEva.get("idList");
        System.out.println(this.idList);
    }

    public void pageCreateCard2(String idList, String key, String token, String nameObject)
    {
        RestAssured.baseURI = "https://api.trello.com";
        String idList2 = "6395f1e1ff0530006eb62e3b";
        Response response = given().log().all().queryParam(idList, idList2)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", nameObject)
                .contentType(ContentType.JSON)
                .when().post("1/cards/");
                //then().log().all().assertThat().statusCode(200);

                assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        JsonPath jsonPathEva = response.jsonPath();
        this.cardId2 =jsonPathEva.get("id");
        System.out.println(this.cardId2);
        this.idList = jsonPathEva.get("idList");
        System.out.println(this.idList);
    }

    public void pageCardUpdate(String key, String token, String nameObject){

        RestAssured.baseURI = "https://api.trello.com";
        System.out.println(cardId2);
       Response response = given().log().all()
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", nameObject)
                .contentType(ContentType.JSON)
                .when().put("1/cards/" + this.cardId2);
                //then().log().all().assertThat().statusCode(200);
                assertEquals(HttpStatus.SC_OK, response.getStatusCode());

    }

    public void pageCardDelete(String key, String token){

        RestAssured.baseURI = "https://api.trello.com";
        given().log().all()
                .queryParam("key", key)
                .queryParam("token", token)
                .contentType(ContentType.JSON)
                .when().delete("1/cards/" + this.cardId2)
                .then().log().all().assertThat().statusCode(200);
    }

    public void pageBoardDelete(String key, String token){
        RestAssured.baseURI = "https://api.trello.com";

        given().log().all()
                .queryParam("key", key)
                .queryParam("token", token)
                .contentType(ContentType.JSON)
                .when().delete("1/boards/" + this.boardId)
                .then().log().all().assertThat().statusCode(200);
    }

}
