package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class checkboxesTests {
    @BeforeAll
    static void setConfigs(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkAndUncheckFisrt(){
        open("https://the-internet.herokuapp.com/checkboxes");
        $("#checkboxes>:first-child").shouldNotBe(Condition.checked);
        $("#checkboxes>:last-child").shouldBe(Condition.checked);
        $("#checkboxes>:first-child").click();
        $("#checkboxes>:first-child").shouldBe(Condition.checked);
        $("#checkboxes>:last-child").shouldBe(Condition.checked);
        $("#checkboxes>:first-child").click();
        $("#checkboxes>:first-child").shouldNotBe(Condition.checked);
        $("#checkboxes>:last-child").shouldBe(Condition.checked);
    }

    @Test
    void checkAndUncheckSecond(){
        open("https://the-internet.herokuapp.com/checkboxes");
        $("#checkboxes>:last-child").shouldBe(Condition.checked);
        $("#checkboxes>:first-child").shouldNotBe(Condition.checked);
        $("#checkboxes>:last-child").click();
        $("#checkboxes>:last-child").shouldNotBe(Condition.checked);
        $("#checkboxes>:first-child").shouldNotBe(Condition.checked);
        $("#checkboxes>:last-child").click();
        $("#checkboxes>:last-child").shouldBe(Condition.checked);
        $("#checkboxes>:first-child").shouldNotBe(Condition.checked);
    }
}
