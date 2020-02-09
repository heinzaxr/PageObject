package cases;

import org.junit.Test;
import pages.LoginPage;
import pages.IssuesPage;
import pages.RepositoriesPage;
import pages.RepositoryTopBarElement;
import utils.BaseHooks;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GithubPageObjectTest extends BaseHooks {

    @Test
    public void githubPageObjectTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .search("Selenide");

        RepositoriesPage repositoriesPage = new RepositoriesPage(driver);
        repositoriesPage.clickFirstRepository();

        RepositoryTopBarElement repositoryTopBarElement = new RepositoryTopBarElement(driver);
        repositoryTopBarElement.openIssues();

        IssuesPage issuesPage = new IssuesPage(driver);
        issuesPage.clickIssuesByNumber(0);

        String title = issuesPage.getIssueTitle();
        assertThat(title, is("Status: Open"));
    }

}