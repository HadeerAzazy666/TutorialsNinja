package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P07_CategoryPage;
import pages.P08_ProductPage;

import static util.Utility.getRandomCategory;
import static util.Utility.getRandomSubCategory;

public class TC10_AddToWishlist extends TestBase{

    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P07_CategoryPage categoryPage;
    P08_ProductPage p08ProductPage;

    String email = "hadtest@gmail.com";
    String password = "had123";
    String cat = getRandomCategory();
    String SubCat = getRandomSubCategory();

    @Test(priority = 1, description = "Add different products to Wishlist")
    public void addDifferentProductsToWishlist() throws InterruptedException {

        homePage = new P01_HomePage(driver);
        loginPage = new P03_LoginPage(driver);
        categoryPage = new P07_CategoryPage(driver);
        p08ProductPage = new P08_ProductPage(driver);

        // build flow
        homePage.clickMyAccount();
        homePage.clickLogin();

        loginPage.login(email, password);

        Thread.sleep(3000);

        categoryPage.clickComponentcat(cat);
        categoryPage.clickMonitorsSubcat(SubCat);
        Thread.sleep(3000);


        p08ProductPage.clickItem2AddToWishlist();
        Thread.sleep(3000);

        //Assertion2
        Assert.assertTrue(p08ProductPage.isAdded("wish list"));


    }
}
