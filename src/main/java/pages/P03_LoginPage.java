package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_LoginPage {

    public P03_LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    // locators
    @FindBy(xpath = "(//form/div/input)[1]")
    WebElement loginEmail;

    @FindBy(xpath = "(//form/div/input)[2]")
    WebElement loginPassword;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement loginButton;

    @FindBy(xpath = "(//div/a[text()='Forgotten Password'])[1]")
    WebElement forgettenPassword;

    // public action methods
    public void login(String email, String password){
        this.loginEmail.sendKeys(email);
        this.loginPassword.sendKeys(password);
        this.loginButton.click();
    }

    public void clickForgettenPassword(){
        forgettenPassword.click();
    }

}
