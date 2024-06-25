package hw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatingModalWindowPage {
    private static final Logger logger = LoggerFactory.getLogger(CreatingModalWindowPage.class);
    private final CreatingModalWindowElements elements;

    public CreatingModalWindowPage() {
        this.elements = new CreatingModalWindowElements();
    }

    public void clickSaveButton() {
        logger.info("Clicking the save button");
        elements.getSubmitButton().click();
    }

    public void closeModalWindow() {
        logger.info("Closing the modal window");
        elements.getCloseModalWindow().click();
    }

    public void enterName(String name) {
        logger.info("Entering name: {}", name);
        elements.getName().setValue(name);
    }

    public void enterLastname(String lastname) {
        logger.info("Entering lastname: {}", lastname);
        elements.getLastname().setValue(lastname);
    }

    public void enterLogin(String login) {
        logger.info("Entering login: {}", login);
        elements.getLogin().setValue(login);
    }

    public void enterPhone(String phone) {
        logger.info("Entering phone: {}", phone);
        elements.getPhone().setValue(phone);
    }
}
