package hw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qatools.TextParser;

import java.util.NoSuchElementException;

public class StudentPage {

    private static final Logger logger = LoggerFactory.getLogger(StudentPage.class);

    private StudentPageElements elements;

    public StudentPage() {
        elements = new StudentPageElements();
    }

    public int TotalStudents () {
        String text = elements.getCountStudents();
        logger.info("All Students: " + text);
        return TextParser.getLastNumberFromString(text);
    }

    public CreatingModalWindowElements clickAddStudent(){
        elements.getCreateButton().click();
        return new CreatingModalWindowElements();
    }

    public GroupTableRow getRowByName(String name){
        return elements.getRowsInGroupTable().stream().map(GroupTableRow::new)
                .filter(row -> row.getName().equals(name))
                .findFirst().orElseThrow(() -> new NoSuchElementException("No row found with name: " + name));
    }
}
