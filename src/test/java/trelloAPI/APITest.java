package trelloAPI;

import Pages.BoardPages;
import Pages.CardPages;
import Pages.ListPages;
import driver.BaseTest;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APITest extends BaseTest {
    BoardPages boardPages=new BoardPages();
    CardPages cardPages =new CardPages();
    ListPages listPages=new ListPages();
    @Test
    public void mainTest(){
        boardPages.createBoard();
        listPages.createListAndGetId(boardPages.getBoardId());
        cardPages.createTwoCards(listPages.getListId());
        cardPages.editCards();
        cardPages.deleteCards();
        boardPages.deleteBoard();
    }


}
