package testcases;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P05_ForgetPasswordPage;

import static util.Utility.*;
import static util.Utility.generateComplexPassword;

public class TC04_ForgettenPassword extends TestBase{

    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P05_ForgetPasswordPage forgetPasswordPage;


    @Test(priority = 1, description = "Validate Forgetten Password")
    public void forgetPassword(ITestContext context) throws InterruptedException {

        homePage = new P01_HomePage(driver);
        loginPage = new P03_LoginPage(driver);
        forgetPasswordPage = new P05_ForgetPasswordPage(driver);
        String emailAddress="hadtest@gmail.com";


        // build flow
        homePage.clickMyAccount();
        homePage.clickLogin();
        loginPage.clickForgettenPassword();
        forgetPasswordPage.insertEmailAddress(emailAddress);
        forgetPasswordPage.clickContinue();

        Thread.sleep(3000);

        // Assertion
        Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/login", "Password is not reset");

        Assert.assertFalse(!forgetPasswordPage.isEmailReset("An email with a confirmation link has been sent your email address."));
    }

}
