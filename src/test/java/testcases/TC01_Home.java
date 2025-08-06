package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;

public class TC01_Home extends TestBase{
    P01_HomePage homePage;

    @Test(priority = 1, description = "Logout")
    public void clickMyAccount() {
        homePage = new P01_HomePage(driver);

        // build flow
        homePage.clickMyAccount();
    }

}
