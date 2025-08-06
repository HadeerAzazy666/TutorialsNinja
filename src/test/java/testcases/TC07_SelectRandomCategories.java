package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import pages.P04_ProfilePage;
import pages.P06_AccountPage;

import static util.Utility.*;
import static util.Utility.generateComplexPassword;

public class TC07_SelectRandomCategories extends TestBase {

    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P04_ProfilePage profilePage;
    P06_AccountPage accountPage;

    String firstName = generateRandomName();
    String lastName = generateRandomName();
    String email = generateRandomGmail();
    String phone = generatePhoneNumber();
    String password = generateComplexPassword(15);


    @Test(priority = 1, description = "Select Random Caregories")
    public void selectRandomCategories() throws InterruptedException {
        homePage = new P01_HomePage(driver);
        registerPage = new P02_RegisterPage(driver);
        profilePage = new P04_ProfilePage(driver);
        accountPage = new P06_AccountPage(driver);

        //  build flow
        homePage.clickMyAccount();
        homePage.clickRegister();
        System.out.println(email);
        System.out.println(password);

        registerPage.registerNewAccount(firstName, lastName, email, phone, password);
        Thread.sleep(3000);

        profilePage.clickContinue();
        Thread.sleep(3000);

        accountPage.selectCategoryThenSubCategory();




    }
}