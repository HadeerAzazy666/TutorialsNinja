package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import pages.P03_LoginPage;
import pages.P04_ProfilePage;

import static util.Utility.*;

public class TC03_Login extends TestBase{
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P03_LoginPage loginPage;
    P04_ProfilePage profilePage;

    String firstName= generateRandomName();
    String lastName=generateRandomName();
    String email=generateRandomGmail();
    String phone= generatePhoneNumber();
    String password=generateComplexPassword(15);




    @Test(priority = 1, description = "Register new account with valid data")
    public void registerAccountWithValidData_P() {
        homePage = new P01_HomePage(driver);
        registerPage = new P02_RegisterPage(driver);


       //  build flow
        homePage.clickMyAccount();
        homePage.clickRegister();
        System.out.println(email);
        System.out.println(password);

        registerPage.registerNewAccount(firstName, lastName, email, phone, password);
    }

    @Test(priority = 2, description = "Logout")
    public void Logout() {

        profilePage= new P04_ProfilePage(driver);

        // build flow
        homePage.clickMyAccount();

        profilePage.clickLogout();
    }

    @Test(priority = 3, description = "Login with valid data")
    public void LoginWithValidData(){
        homePage=new P01_HomePage(driver);
        loginPage=new P03_LoginPage(driver);


        // build flow
        homePage.clickMyAccount();
        homePage.clickLogin();

        loginPage.login(email,password);
   }
}
