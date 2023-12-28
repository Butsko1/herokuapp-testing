package elements;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class Drag_and_drop_tests {
    @BeforeAll
    static void setConfigs(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void moveAtoB() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }

    @Test
    void getOverClass() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement element = $("#column-a");
        actions().clickAndHold(element).moveByOffset(50,50).perform();
        $("#column-a").shouldHave(cssClass("over"));
    }
}
