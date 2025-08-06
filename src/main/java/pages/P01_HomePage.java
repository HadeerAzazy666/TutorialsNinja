package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_HomePage {

    public P01_HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    // locators
    @FindBy(xpath = "//ul/li/a[@title=\"My Account\"]")
    WebElement myAccount;

    @FindBy(xpath = "//ul/li/a[text()='Register']")
    WebElement register;

    @FindBy(xpath = "//ul/li/a[text()='Login']")
    WebElement login;


    // public action methods
    public void clickMyAccount(){
        myAccount.click();
    }

    public void clickRegister(){
        register.click();
    }

    public void clickLogin(){
        login.click();
    }
}
