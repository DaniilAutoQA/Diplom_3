package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static site.nomoreparties.stellarburgers.UserActionApi.*;

public class NavigationTest extends TestBase {

    User user = new User("Иван", "qw18@ya.ru", "123132");
    String accessToken;

    @Before
    public void setUp() {
        createUser(user);
        accessToken = getAccessTokenUser(user);
    }

    @Step("authorization User")
    public void authorizationUser(MainPage mainPage) {
        mainPage
                .clickOnThePersonalAccountButton()
                .feelLoginForm(user.getEmail(), user.getPassword())
                .clickOnTheLogInButton();
    }

    @Test
    @DisplayName("Check go to the login page by the click Personal Account button")
    public void goToTheLoginPage() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage.clickOnThePersonalAccountButton();
        webdriver().shouldHave(url(baseUrl + "login"), Duration.ofSeconds(3));
    }

    @Test
    @DisplayName("Check go to the Constructor page by the click Constructor button from Profile page")
    public void goToTheMainPageByTheClickConstructorButton() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        authorizationUser(mainPage);
        mainPage.clickOnThePersonalAccountButton();
        mainPage.clickOnTheConstructorButton();
        mainPage.getPackBurgerHeader().shouldBe(visible);
    }

    @Test
    @DisplayName("Check go to the Constructor page by the click Stellar Burgers logo from Profile page")
    public void goToTheMainPageByTheClickStellarBurgersLogo() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        authorizationUser(mainPage);
        mainPage.clickOnThePersonalAccountButton();
        mainPage.clickOnTheStellarBurgersLogo();
        mainPage.getPackBurgerHeader().shouldBe(visible);
    }

    @Test
    @DisplayName("Check go to the Stuffing block by the click Stuffing button")
    public void goToTheStuffingBlock() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage
                .clickOnTheConstructorButton()
                .goToStuffingBlock()
                .getSelectedBlock().shouldHave(text("Начинки"));
    }

    @Test
    @DisplayName("Check go to the Sauces block by the click Sauces button")
    public void goToTheSaucesBlock() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage
                .clickOnTheConstructorButton()
                .goToSaucesBlock()
                .getSelectedBlock().shouldHave(text("Соусы"));
    }

    @Test
    @DisplayName("Check go to the Buns block by the click Buns button")
    public void goToTheBunsBlock() {
        MainPage mainPage = open(baseUrl, MainPage.class);
        mainPage
                .clickOnTheConstructorButton()
                .goToSaucesBlock()
                .goToBunsBlock()
                .getSelectedBlock().shouldHave(text("Булки"));
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            deleteUser(accessToken);
        }
    }

}
