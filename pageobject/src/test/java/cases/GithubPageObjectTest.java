package cases;

import org.junit.Test;
import pages.*;
import utils.BaseHooks;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GithubPageObjectTest extends BaseHooks {

    @Test
    public void githubPageObjectTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .search("Selenide");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickFirstRepository();

        RepositoryTopBarElement repositoryTopBarElement = new RepositoryTopBarElement(driver);
        repositoryTopBarElement.openIssues();

        ListOfIssuesPage listOfIssuesPage = new ListOfIssuesPage(driver);
        listOfIssuesPage.clickIssuesByNumber(0);

        IssuePage issuePage = new IssuePage(driver);
        String title = issuePage.getIssueTitle();

        assertThat(title, is("Status: Open"));
    }

}