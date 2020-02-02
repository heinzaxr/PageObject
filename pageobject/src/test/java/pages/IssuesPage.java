package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IssuesPage extends BasePage {
    private By issueList = By.xpath("//a[@data-hovercard-type='issue']");
    private By noOneAssigned = By.xpath("//span[contains(text(),'No one assigned')]");

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    public IssuesPage clickIssuesByNumber(int number) {
        List<WebElement> elements = driver.findElements(issueList);
        elements.get(number).click();

        return new IssuesPage(driver);
    }

    public boolean noOneAssigned() {
        return driver.findElement(noOneAssigned).isDisplayed();
    }

}
