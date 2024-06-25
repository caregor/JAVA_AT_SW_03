package hw3;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginPageTest {
    static LoginPage loginPage;
    static StudentPage studentPage;
    static CreatingModalWindowPage modalWindow;
    private String login = "GB202305ee7822";
    private String password = "a5ad0ee5ae";
    private String name = "Galya";
    private String lastname = "Petrova";
    private String loginName = "Testlogin5";

    @BeforeAll
    static void init(){
        Selenide.open("https://test-stand.gb.ru/login");
        loginPage = Selenide.page(LoginPage.class);
    }

    @Test
    void invalidCredentialTest () {
        loginPage.logIn("", "");
        Assertions.assertEquals("401", loginPage.getError());

    }

    @Test
    void addNewStudentTest() {
        loginPage.logIn(login, password);
        studentPage = Selenide.page(StudentPage.class);
        int currentStudents = studentPage.TotalStudents();
        studentPage.clickAddStudent();
        modalWindow = Selenide.page(CreatingModalWindowPage.class);
        modalWindow.enterName(name);
        modalWindow.enterLastname(lastname);
        modalWindow.enterLogin(loginName);
        modalWindow.clickSaveButton();
        modalWindow.closeModalWindow();
        int actualStudentsCount = studentPage.TotalStudents();
        GroupTableRow row = studentPage.getRowByName(String.format("%s %s", lastname, name));
        row.clickTrashIcon();
        String changedStatus = row.getStatus();

        Assertions.assertEquals("inactive", changedStatus);

        row.clickRestoreFromTrashIcon();
        String revertStatus = row.getStatus();

        Assertions.assertEquals("active", revertStatus);
        Assertions.assertEquals(currentStudents + 1, actualStudentsCount);

    }
}
