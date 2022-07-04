package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static site.nomoreparties.stellarburgers.UserActionApi.*;

public class AuthorizationUserTest extends TestBase {

    User user = new User("Иван", "qw18e@ya.ru", "123132");
    String accessToken;

    @Before
    public void setUp() {
        createUser(user);
        accessToken = getAccessTokenUser(user);
    }

    @Test
    @DisplayName("Check authorization user by the Personal Account button")
    public void authorizationUserFromPersonalAccountButton() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage
                .clickOnThePersonalAccountButton()
                .feelLoginForm(user.getEmail(), user.getPassword())
                .clickOnTheLogInButton()
                .clickOnThePersonalAccountButton()
                .getLogInButton().shouldBe(not(visible));
    }

    @Test
    @DisplayName("Check authorization user by the login button from mane page")
    public void authorizationUserFromManePageByLoginButton() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage
                .clickOnTheSignInButton()
                .feelLoginForm(user.getEmail(), user.getPassword())
                .clickOnTheLogInButton();
        mainPage.getPlaceAnOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("Check authorization user by the login button from registration page")
    public void authorizationUserFromRegistrationPageByLoginButton() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage
                .clickOnThePersonalAccountButton()
                .clickOnTheRegistrationLink()
                .clickOnTheSignInButton()
                .feelLoginForm(user.getEmail(), user.getPassword())
                .clickOnTheLogInButton();
        mainPage.getPlaceAnOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("Check authorization user by the login button from recover password page")
    public void authorizationUserFromRecoverPasswordPageByLoginButton() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage
                .clickOnThePersonalAccountButton()
                .clickOnTheRecoverPasswordLink()
                .clickOnTheLogInLink()
                .feelLoginForm(user.getEmail(), user.getPassword())
                .clickOnTheLogInButton();
        mainPage.getPlaceAnOrderButton().shouldBe(visible);

    }

    @Test
    @DisplayName("Check sign out account")
    public void signOutAccount() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage
                .clickOnThePersonalAccountButton()
                .feelLoginForm(user.getEmail(), user.getPassword())
                .clickOnTheLogInButton()
                .clickOnThePersonalAccountButton();
        page(ProfilePage.class).clickOnTheSignOut();
        webdriver().shouldHave(url(baseUrl + "login"));
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            deleteUser(accessToken);
        }
    }
}
