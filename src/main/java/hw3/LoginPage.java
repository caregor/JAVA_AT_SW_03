package hw3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement loginInput = $x("//input[@type='text']");
    private SelenideElement inputPasswd = $x("//input[@type='password']");
    private SelenideElement submitButton = $x("//button[@type='submit']");
    private SelenideElement error = $x("//div[contains(@class, 'error-block')]/h2");

    public String getError() {
        return error.shouldBe(Condition.visible).getText();
    }

    public void logIn(String login, String password) {
        loginInput.shouldBe(Condition.visible).sendKeys(login);
        inputPasswd.shouldBe(Condition.visible).sendKeys(password);
        submitButton.shouldBe(Condition.visible).click();
    }


}
