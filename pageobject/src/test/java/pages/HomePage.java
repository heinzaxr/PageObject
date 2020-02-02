package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String URL = "https://github.com/";
    private By searchInput = By.xpath("//input[@name='q']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(URL);

        return this;
    }

    public RepositoriesPage search(String text) {
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);

        return new RepositoriesPage(driver);
    }

}
