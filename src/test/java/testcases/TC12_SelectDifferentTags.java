package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P06_AccountPage;
import pages.P07_CategoryPage;

import static util.Utility.getRandomCategory;
import static util.Utility.getRandomSubCategory;

public class TC12_SelectDifferentTags extends TestBase{


    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P07_CategoryPage categoryPage;
    P06_AccountPage accountPage;

    String email = "hadtest@gmail.com";
    String password = "had123";
    String cat = getRandomCategory();
    String SubCat = getRandomSubCategory();

    @Test(priority = 1, description = "Filter With Color")
    public void selectDifferentTags() throws InterruptedException {

        homePage = new P01_HomePage(driver);
        loginPage = new P03_LoginPage(driver);
        categoryPage = new P07_CategoryPage(driver);
        accountPage = new P06_AccountPage(driver);

        // build flow
        homePage.clickMyAccount();
        homePage.clickLogin();

        loginPage.login(email, password);

        Thread.sleep(3000);

        accountPage.selectDifferentTags();



    }
}
