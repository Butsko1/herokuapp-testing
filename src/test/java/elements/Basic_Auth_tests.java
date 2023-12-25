package elements;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Basic_Auth_tests {
    @BeforeAll
    static void setConfigs(){
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    void restart(){
        Selenide.closeWebDriver(); //Костыль, чтобы сбросить базовую авторизацию в каждом тесте
    }

    @Test
    void successAuthTest(){
        open("https://the-internet.herokuapp.com/basic_auth", "","admin", "admin");
        $("#content>.example>p").shouldHave(text("Congratulations! You must have the proper credentials."));
    }
    @Test
    void unsuccessAuthTest(){
        open("https://the-internet.herokuapp.com/basic_auth", "","adminc", "admin");
        $("#content>.example>p").shouldNotBe(exist);
    }
}
