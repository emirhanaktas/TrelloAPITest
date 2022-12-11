package org.example.test;

import org.example.BasePage.BasePage;
import org.junit.Test;

public class TrelloTest extends BasePage {


    @Test
    public void createBoard()
    {
        pageCreateBoard("Baslik2", key, token);
    }


    @Test
    public void createCard1(){
       // String idList = "6395f1e1ff0530006eb62e3b";
        pageCreateCard2( "idList",
                key,
                token,
                "New Card - 1");
    }

    @Test
    public void createCard2() {
        // String idList = "6395f1e1ff0530006eb62e3b";
        pageCreateCard2("idList",
                key,
                token,
                "New Card - 2 ");
    }


        @Test
    public void cardUpdate(){

      pageCardUpdate(key, token, "Yeni Kart İsmi 22222");
    }

    @Test
    public void cardDelete(){
        pageCardDelete(key, token);

    }

    @Test
    public void boardDelete(){
        pageBoardDelete(key, token);
    }

}

