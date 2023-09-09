package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.Before;

import static com.codeborne.selenide.Browsers.CHROME;

public class TestBase {

    public String baseUrl = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void init() {
        Configuration.startMaximized = true;
        Configuration.browser = CHROME;
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        // запуск тестов в yandex браузере
        //System.setProperty("webdriver.chrome.driver", "C:\\Tools\\yandexdriver.exe");

    }

}




