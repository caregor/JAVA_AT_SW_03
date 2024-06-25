package hw3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CreatingModalWindowElements {
    private ElementsCollection inputFields = $$x("//input[@type='text']");
    private SelenideElement submitButton = $x("//button[@type='submit']");
    private SelenideElement closeModalWindow = $x("//button[@data-mdc-dialog-action='close']");

    public SelenideElement getName() {
        return inputFields.get(0);
    }

    public SelenideElement getLastname() {
        return inputFields.get(1);
    }

    public SelenideElement getLogin() {
        return inputFields.get(2);
    }

    public SelenideElement getPhone() {
        return inputFields.get(3);
    }

    public SelenideElement getSubmitButton() {
        return submitButton.shouldBe(visible);
    }

    public SelenideElement getCloseModalWindow() {
        return closeModalWindow.shouldBe(visible);
    }

}
