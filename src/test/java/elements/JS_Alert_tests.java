package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.*;

public class JS_Alert_tests {
    @BeforeAll
    static void setConfigs(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void alertConfirm(){
        open("https://the-internet.herokuapp.com/context_menu");
        $("#hot-spot").contextClick();
        Alert al = switchTo().alert();
        Assertions.assertEquals(al.getText(),"You selected a context menu");
        al.accept();
    }
}
