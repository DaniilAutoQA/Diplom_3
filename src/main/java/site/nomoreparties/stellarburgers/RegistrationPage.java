package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends MainPage {

    // локатор поля ввода Имени
    @FindBy(how = How.XPATH, using = ".//label[text()= 'Имя']/following-sibling::input")
    private SelenideElement nameField;

    // локатор поля ввода Email
    @FindBy(how = How.XPATH, using = ".//label[text()= 'Email']/following-sibling::input")
    private SelenideElement emailField;

    // локатор поля ввода Пароля
    @FindBy(how = How.XPATH, using = ".//input[@name= 'Пароль']")
    private SelenideElement passwordField;

    // локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()= 'Зарегистрироваться']")
    private SelenideElement submitRegistrationButton;

    // локатор гиперссылки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text()= 'Войти']")
    private SelenideElement logInLink;

    // локатор сообщения "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[@class= 'input__error text_type_main-default']")
    private SelenideElement incorrectPassword;

    //метод перехода в форму авторизации
    @Step("Click on the logIn link")
    public LoginPage clickOnTheLogInLink() {
        logInLink.click();
        return page(LoginPage.class);
    }

    //метод заполнения формы регистрации пользователя
    @Step("Feel Registration Form")
    public RegistrationPage feelRegistrationForm(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
        return this;
    }

    //метод клика по кнопке Зарегистрироваться
    @Step("Click on the Registration button")
    public void clickOnTheSubmitButton() {
        submitRegistrationButton.click();
    }

    //метод заполнения поля Имя
    public void setName(String name) {
        nameField.setValue(name);
    }

    // метод возвращает элемент уведомления о некорректном пароле
    public SelenideElement getIncorrectPassword() {
        return incorrectPassword;
    }
}
