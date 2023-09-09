package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    // локатор поля ввода Email
    @FindBy(how = How.XPATH, using = ".//label[text()= 'Email']/following-sibling::input")
    private SelenideElement emailField;

    // локатор поля ввода Пароля
    @FindBy(how = How.XPATH, using = ".//input[@name= 'Пароль']")
    private SelenideElement passwordField;

    // локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//button[text()= 'Войти']")
    private SelenideElement logInButton;

    // локатор гиперссылки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[text()= 'Зарегистрироваться']")
    private SelenideElement registrationLink;

    // локатор гиперссылки Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[text()= 'Восстановить пароль']")
    private SelenideElement recoverPasswordLink;

    //метод заполнения формы авторизации пользователя
    @Step("Feel login form")
    public LoginPage feelLoginForm(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        return this;
    }

    //метод клика по гиперссылке Зарегистрироваться
    @Step("Click on the registration link")
    public RegistrationPage clickOnTheRegistrationLink() {
        registrationLink.click();
        return page(RegistrationPage.class);
    }

    //метод клика по гиперссылке восстановить пароль
    @Step("Click on the recover password link")
    public RecoverPasswordPage clickOnTheRecoverPasswordLink() {
        recoverPasswordLink.click();
        return page(RecoverPasswordPage.class);
    }

    //метод клика по кнопке Войти
    @Step("Click on the logIn button")
    public MainPage clickOnTheLogInButton() {
        logInButton.click();
        return page(MainPage.class);
    }

    //метод возвращает элемент кнопки Войти
    public SelenideElement getLogInButton() {
        return logInButton;
    }

}
