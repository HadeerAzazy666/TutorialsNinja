package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P04_ProfilePage;

public class TC05_SearchProduct extends TestBase{

    P03_LoginPage loginPage;
    P01_HomePage homePage;
    P04_ProfilePage profilePage;


    String email = "hadtest@gmail.com";
    String password = "had123";
    String searchValue= "Apple Cinema 30\"";

    @Test(priority = 1, description = "Login then Search for any product")
    public void searchForProduct() throws InterruptedException {

        homePage = new P01_HomePage(driver);
        loginPage = new P03_LoginPage(driver);
        profilePage = new P04_ProfilePage(driver);



        // Login
        homePage.clickMyAccount();
        homePage.clickLogin();
        loginPage.login(email, password);
        Thread.sleep(3000);

        //Search for any product

        profilePage.insertValue(searchValue);
        profilePage.clickSearch();



    }
}
