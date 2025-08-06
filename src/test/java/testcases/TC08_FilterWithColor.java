package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P07_CategoryPage;

import static util.Utility.getRandomCategory;
import static util.Utility.getRandomSubCategory;

public class TC08_FilterWithColor extends TestBase {

    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P07_CategoryPage categoryPage;

    String email = "hadtest@gmail.com";
    String password = "had123";
    String cat = getRandomCategory();
    String SubCat = getRandomSubCategory();

    @Test(priority = 1, description = "Filter With Color")
    public void filterWithColor() throws InterruptedException {

        homePage = new P01_HomePage(driver);
        loginPage = new P03_LoginPage(driver);
        categoryPage= new P07_CategoryPage(driver);

        // build flow
        homePage.clickMyAccount();
        homePage.clickLogin();

        loginPage.login(email, password);

        Thread.sleep(3000);

        categoryPage.clickComponentcat(cat);
        categoryPage.clickMonitorsSubcat(SubCat);
        Thread.sleep(3000);
        categoryPage.clickItem1();
        categoryPage.selectColor();

    }

}
