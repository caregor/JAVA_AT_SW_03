package hw3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class StudentPageElements {
    private static final Logger logger = LoggerFactory.getLogger(StudentPageElements.class);

    private SelenideElement createButton = $("#create-btn");
    private ElementsCollection rowsInGroupTable = $$x("//table[@aria-label='Dummies list']/tbody/tr");
    private SelenideElement countStudents = $x("//div[@class='mdc-data-table__pagination-total']");

    public ElementsCollection getRowsInGroupTable() {
        logger.info("Size of table: {}", rowsInGroupTable.size());
        return rowsInGroupTable;
    }

    public SelenideElement getCreateButton() {
        return createButton.shouldBe(visible);
    }

    public String getCountStudents() {
        return countStudents.shouldBe(visible).shouldNotHave(text("... loading")).getText();
    }
}
