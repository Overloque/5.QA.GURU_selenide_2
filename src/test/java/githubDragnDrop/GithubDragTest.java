package githubDragnDrop;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

public class GithubDragTest {
    @Test
    void gitCheckPage() {

        //open main github page
        open("https://github.com/");

        //hover Solutions menu
        $(".header-menu-wrapper").$(byText("Solutions")).hover();

        //Choose Solutions -> Enterprize point
        $(".header-menu-wrapper").$(byText("Enterprise")).click();

        //Check loaded page (title - "Build like the best.")
        $(".enterprise-hero h1").shouldHave(text("Build like the best"));
    }

    @Test
    void dragNDropTest() {

        // open https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // check rectangles' positions before
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        // replace rectangle A to B
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));

        // check replaced rectangle's positions
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }

    // ниже тест через actions не работает
    @Test
    void dragNDropActionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
}
