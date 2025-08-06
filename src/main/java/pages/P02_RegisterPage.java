package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_RegisterPage {

    public P02_RegisterPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    // locators
    @FindBy(xpath = "(//div/input)[2]")
    WebElement firstName;

    @FindBy(xpath = "(//div/input)[3]")
    WebElement lastName;

    @FindBy(xpath = "(//div/input)[4]")
    WebElement email;

    @FindBy(xpath = "(//div/input)[5]")
    WebElement phone;

    @FindBy(xpath = "(//div/input)[6]")
    WebElement password;

    @FindBy(xpath = "(//div/input)[7]")
    WebElement confirmPassword;

    @FindBy(xpath = "(//div/input)[8]")
    WebElement conditions;

    @FindBy(xpath = "(//div/input)[9]")
    WebElement continueButton;

    @FindBy(xpath = "(//h1)[2]")
    WebElement successfullyRegisterMessage;

    // public action methods
    public void registerNewAccount(String firstName,String lastName, String email, String phone, String password){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
        this.conditions.click();
        this.continueButton.click();
    }
    // check if registered successfully
    public boolean isRegisterSuccessfully(String successfullyMessage){
        return this.successfullyRegisterMessage.getText().equals(successfullyMessage);
    }
}
