package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    // локатор кнопки Выйти
    @FindBy(how = How.XPATH, using = ".//button[text()= 'Выход']")
    private SelenideElement SignOutButton;

    //метод клика по кнопке Выйти
    @Step("Click on the signOut button")
    public void clickOnTheSignOut() {
        SignOutButton.click();
    }

}
