package hw3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class GroupTableRow {
    private final SelenideElement root;

    public GroupTableRow(SelenideElement root) {
        this.root = root;
    }

    public String getName() {
        return root.$x("./td[2]").getText();
    }

    public String getStatus() {
        return root.$x("./td[4]").getText();
    }

    public void clickTrashIcon() {
        root.$x("./td/button[text()='delete']").click();
        root.$x("./td/button[text()='restore_from_trash']").shouldBe(Condition.visible, Duration.ofSeconds(30));
    }

    public void clickRestoreFromTrashIcon() {
        root.$x("./td/button[text()='restore_from_trash']").click();
        root.$x("./td/button[text()='delete']").shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}

