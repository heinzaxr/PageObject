package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryTopBarElement extends AbstractPage {
    private By issues = By.xpath("//a//span[text()='Issues']");

    public RepositoryTopBarElement(WebDriver driver) {
        super(driver);
    }

    public IssuesPage openIssues() {
        driver.findElement(issues).click();

        return new IssuesPage(driver);
    }

}
