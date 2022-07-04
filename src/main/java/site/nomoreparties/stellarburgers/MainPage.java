package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    // локатор кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = ".//p[text()= 'Личный Кабинет']")
    private SelenideElement personalAccountButton;

    // локатор кнопки Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()= 'Конструктор']")
    private SelenideElement constructorButton;

    // локатор кнопки логотипа Stellar Burgers
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement stellarBurgersLogo;

    // локатор названия Header Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[text()= 'Соберите бургер']")
    private SelenideElement packBurgerHeader;

    // локатор кнопки перехода в раздел Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()= 'Начинки']")
    private SelenideElement stuffingButton;

    // локатор названия блока Начинки
    @FindBy(how = How.XPATH, using = ".//h2[text()= 'Начинки']")
    private SelenideElement stuffingHeader;

    // локатор кнопки перехода в раздел Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()= 'Соусы']")
    private SelenideElement saucesButton;

    // локатор названия блока Соусы
    @FindBy(how = How.XPATH, using = ".//h2[text()= 'Соусы']")
    private SelenideElement saucesHeader;

    // локатор кнопки перехода в раздел Булки
    @FindBy(how = How.XPATH, using = ".//span[text()= 'Булки']")
    private SelenideElement bunsButton;

    // локатор названия блока Булки
    @FindBy(how = How.XPATH, using = ".//h2[text()= 'Булки']")
    private SelenideElement bunsHeader;

    // локатор элемента выбранного блока конструктора
    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    private SelenideElement selectedBlock;

    // локатор кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()= 'Войти в аккаунт']")
    private SelenideElement signInButton;

    // локатор кнопки Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()= 'Оформить заказ']")
    private SelenideElement placeAnOrderButton;

    // локатор поля Логин в личном кабинете
    @FindBy(how = How.XPATH, using = ".//label[text()= 'Логин']/following-sibling::input")
    private SelenideElement loginField;

    @Step("Click on the Personal Account button")
    public LoginPage clickOnThePersonalAccountButton() {
        personalAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("Click on the Constructor button")
    public MainPage clickOnTheConstructorButton() {
        constructorButton.click();
        return this;
    }

    @Step("Click on the Stellar Burgers logo")
    public void clickOnTheStellarBurgersLogo() {
        stellarBurgersLogo.click();
    }

    // метод возвращает элемент выбранного блока
    public SelenideElement getSelectedBlock() {
        return selectedBlock;
    }

    // метод клика по кнопке "Начинки"
    @Step("Click on the Stuffing button")
    public MainPage goToStuffingBlock() {
        stuffingButton.click();
        return this;
    }

    // метод возвращает элемент блока "Начинки"
    public SelenideElement getStuffingBlock() {
        return stuffingHeader;
    }

    // метод клика по кнопке "Соусы"
    @Step("Click on the Sauces button")
    public MainPage goToSaucesBlock() {
        saucesButton.click();
        return this;
    }

    // метод возвращает элемент блока "Соусы"
    public SelenideElement getSaucesBlock() {
        return saucesHeader;
    }

    // метод клика по кнопке "Булки"
    @Step("Click on the Buns button")
    public MainPage goToBunsBlock() {
        bunsButton.click();
        return this;
    }

    // метод возвращает элемент блока "Булки"
    public SelenideElement getBunsBlock() {
        return bunsHeader;
    }

    // метод возвращает локатор кнопки Оформить заказ
    public SelenideElement getPlaceAnOrderButton() {
        return placeAnOrderButton;
    }

    // метод возвращает локатор кнопки Оформить заказ
    public SelenideElement getPackBurgerHeader() {
        return packBurgerHeader;
    }

    // метод возвращает значение поля логин
    public SelenideElement getLoginField() {
        return loginField;
    }

    // метод клика по кнопке "Войти в аккаунт" с главной страницы
    @Step("Click on SignIn button from mane page")
    public LoginPage clickOnTheSignInButton() {
        personalAccountButton.click();
        return page(LoginPage.class);
    }

}
