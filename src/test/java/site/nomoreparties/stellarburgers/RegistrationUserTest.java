package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static site.nomoreparties.stellarburgers.UserActionApi.deleteUser;
import static site.nomoreparties.stellarburgers.UserActionApi.getAccessTokenUser;

public class RegistrationUserTest extends TestBase {

    User user = new User("Иван", "qw18e@ya.ru", "123132");

    @Test
    @DisplayName("Check registration user")
    public void registrationUser() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage.clickOnThePersonalAccountButton()
                .clickOnTheRegistrationLink()
                .feelRegistrationForm(user.getName(), user.getEmail(), user.getPassword())
                .clickOnTheSubmitButton();
        webdriver().shouldHave(url(baseUrl + "login"), Duration.ofSeconds(3));
        deleteUser(getAccessTokenUser(user));
    }

    @Test
    @DisplayName("Check registration user with incorrect Password")
    public void registrationUserWithIncorrectPassword() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage.clickOnThePersonalAccountButton()
                .clickOnTheRegistrationLink()
                .feelRegistrationForm(user.getName(), user.getEmail(), "123")
                .clickOnTheSubmitButton();
        page(RegistrationPage.class).getIncorrectPassword().shouldHave(text("Некорректный пароль"));

    }
}
