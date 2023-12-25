package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Add_and_remove_tests {

    @BeforeAll
    static void setConfigurations(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void addElementTest(){
        open("https://the-internet.herokuapp.com/add_remove_elements/");
        $(byText("Add Element")).click();
        $(byText("Delete")).shouldBe(visible);
    }

    @Test
    void deleteElementTest(){
        open("https://the-internet.herokuapp.com/add_remove_elements/");
        $(byText("Add Element")).click();
        $(byText("Delete")).click();
        $("#elements").shouldBe(empty);
    }

}
