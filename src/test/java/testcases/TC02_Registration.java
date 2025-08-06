package testcases;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_RegisterPage;

import static util.Utility.*;

public class TC02_Registration extends TestBase{

    P01_HomePage homePage;
    P02_RegisterPage registerPage;

    String firstName= generateRandomName();
    String lastName=generateRandomName();
    String email=generateRandomGmail();
    String phone= generatePhoneNumber();
    String password=generateComplexPassword(15);

    // assertion var

    @Test(priority = 1, description = "Register new account with valid data")
    public void registerAccountWithValidData_P(){
        homePage=new P01_HomePage(driver);
        registerPage=new P02_RegisterPage(driver);
//        context.setAttribute("email", email);
//        context.setAttribute("password", password);

        // build flow
        homePage.clickMyAccount();
        homePage.clickRegister();

        System.out.println(email);
        System.out.println(password);

        registerPage.registerNewAccount(firstName,lastName,email,phone,password);

        // Assertion
        Assert.assertEquals(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/success","Not Registered Successfully");

        Assert.assertFalse(!registerPage.isRegisterSuccessfully("Your Account Has Been Created!"));

        // soft assertion
        softAssert=new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/success","Not Registered Successfully");

        softAssert.assertFalse(!registerPage.isRegisterSuccessfully("Your Account Has Been Created!"));

        softAssert.assertAll();

        // fluent assertion
    }

    @Test(priority = 2, description = "Register new account with duplicate data")
    public void registerAccountWithDuplicateData_N(){
        homePage=new P01_HomePage(driver);
        registerPage=new P02_RegisterPage(driver);

        email="aikjGH6hq7@gmail.com";


        // build flow
        homePage.clickMyAccount();
        homePage.clickRegister();

        registerPage.registerNewAccount(firstName,lastName,email,phone,password);

        // Assertion
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/success","Not Registered Successfully");

        Assert.assertFalse(registerPage.isRegisterSuccessfully("Your Account Has Been Created!"));
    }
}
