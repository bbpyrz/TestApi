package trelloAPI;

import Pages.BoardPages;
import Pages.CartPages;
import Pages.ListPages;
import driver.BaseTest;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APITest extends BaseTest {
    BoardPages boardPages=new BoardPages();
    CartPages cartPages=new CartPages();
    ListPages listPages=new ListPages();
    @Test
    public void mainTest(){
        boardPages.createBoard();
        listPages.createListAndGetId(boardPages.getBoardId());
        cartPages.createTwoCards(listPages.getListId());
        cartPages.editCards();
        cartPages.deleteCards();
        boardPages.deleteBoard();
    }


}
