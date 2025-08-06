package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import pages.P03_LoginPage;
import pages.P04_ProfilePage;

import static util.Utility.*;
import static util.Utility.generateComplexPassword;

public class TC06_SwitchBetweenCurrencies extends TestBase{

    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P04_ProfilePage profilePage;

    String firstName= generateRandomName();
    String lastName=generateRandomName();
    String email=generateRandomGmail();
    String phone= generatePhoneNumber();
    String password=generateComplexPassword(15);


    @Test(priority = 1, description = "Switch between Currencies rondomly")
    public void switchBetweenCurrenciesRondomly() throws InterruptedException {
        homePage = new P01_HomePage(driver);
        registerPage = new P02_RegisterPage(driver);
        profilePage = new P04_ProfilePage(driver);


        //  build flow
        homePage.clickMyAccount();
        homePage.clickRegister();
        System.out.println(email);
        System.out.println(password);

        registerPage.registerNewAccount(firstName, lastName, email, phone, password);
        Thread.sleep(3000);

        profilePage.clickContinue();

        profilePage.clickCurrencyArrow();

        profilePage.selectRandomCurrency();

//        profilePage.clickCurrencyArrow();
//        profilePage.selectEuro();
//        Thread.sleep(3000);
//        profilePage.clickCurrencyArrow();
//        profilePage.selectPound();
//        Thread.sleep(3000);
//        profilePage.clickCurrencyArrow();
//        profilePage.selectUSDollar();



    }
}
