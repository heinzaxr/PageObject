package cases;

import org.junit.Test;
import pages.HomePage;
import pages.IssuesPage;
import pages.RepositoriesPage;
import pages.RepositoryTopBarElement;
import utils.BaseHooks;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GithubPageObjectTest extends BaseHooks {

    @Test
    public void githubPageObjectTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open()
                .search("Selenide");

        RepositoriesPage repositoriesPage = new RepositoriesPage(driver);
        repositoriesPage.clickFirstRepository();

        RepositoryTopBarElement repositoryTopBarElement = new RepositoryTopBarElement(driver);
        repositoryTopBarElement.openIssues();

        IssuesPage issuesPage = new IssuesPage(driver);
        issuesPage.clickIssuesByNumber(0);
        boolean noOneAssigned = issuesPage.noOneAssigned();
        assertThat(noOneAssigned, is(true));
    }

}