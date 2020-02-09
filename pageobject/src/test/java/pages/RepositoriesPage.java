package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoriesPage extends AbstractPage {
    private By firstRepository = By.xpath("//a[@href='/selenide/selenide']");

    public RepositoriesPage(WebDriver driver) {
        super(driver);
    }

    public RepositoryTopBarElement clickFirstRepository() {
        driver.findElement(firstRepository).click();

        return new RepositoryTopBarElement(driver);
    }

}
