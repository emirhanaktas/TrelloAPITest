package org.example;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

public class AppTest
{

    public final String key = "9bc0a418f399ad3beb4041ac64f04b34";
    public final String token = "b8f464465ab6862f082014bfda18cda5f066a4c379d70c53af9f3e57a25c57e9";



    @Test
    public void createBoard()
    {
        RestAssured.baseURI = "https://api.trello.com";

        given().log().all().queryParam("name", "YeniKart4")
                .queryParam("key", key)
                .queryParam("token", token)
                .contentType(ContentType.JSON)
                .when().post("/1/boards/")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void createCard(){
        RestAssured.baseURI = "https://api.trello.com";

        given().log().all().queryParam("idList", "6395e0ad05ee39022155071b")
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", "Sonunda2")
                .contentType(ContentType.JSON)
                .when().post("1/cards/")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void cardUpdate(){

        RestAssured.baseURI = "https://api.trello.com";
        String cardId = "6395e2d71a2a1c0099e18a6c";

        given().log().all()
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", "Sonunda2 Guncellendi")
                .contentType(ContentType.JSON)
                .when().put("1/cards/" + cardId)
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void cardDelete(){

        RestAssured.baseURI = "https://api.trello.com";
        String cardId = "6395e2d71a2a1c0099e18a6c";

        given().log().all()
                .queryParam("key", "9bc0a418f399ad3beb4041ac64f04b34")
                .queryParam("token", "b8f464465ab6862f082014bfda18cda5f066a4c379d70c53af9f3e57a25c57e9")
                .contentType(ContentType.JSON)
                .when().delete("1/cards/" + cardId)
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void boardDelete(){

        RestAssured.baseURI = "https://api.trello.com";
        String boardId = "6395ebcdd6e06100923cdcb7";

        given().log().all()
                .queryParam("key", "9bc0a418f399ad3beb4041ac64f04b34")
                .queryParam("token", "b8f464465ab6862f082014bfda18cda5f066a4c379d70c53af9f3e57a25c57e9")
                .contentType(ContentType.JSON)
                .when().delete("1/boards/" + boardId)
                .then().log().all().assertThat().statusCode(200);
    }



}
