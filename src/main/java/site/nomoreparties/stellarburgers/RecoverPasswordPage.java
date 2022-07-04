package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoverPasswordPage {

    // локатор гиперссылки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text()= 'Войти']")
    private SelenideElement logInLink;

    @Step("Click on the logIn link")
    public LoginPage clickOnTheLogInLink() {
        logInLink.click();
        return page(LoginPage.class);
    }
}
