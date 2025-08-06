package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_ForgetPasswordPage {
    public P05_ForgetPasswordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    // locators
    @FindBy(xpath = "(//div/input)[2]")
    WebElement emailAddress;

    @FindBy(xpath = "//div/input[@value=\"Continue\"]")
    WebElement continueButton;

    @FindBy(xpath = "//div[text()='An email with a confirmation link has been sent your email address.']")
    WebElement SuccessfulResetMessage;

    public void insertEmailAddress(String emailAddress){

        this.emailAddress.sendKeys(emailAddress);

    }
    public void clickContinue(){

        continueButton.click();

    }
    // check if registered successfully
    public boolean isEmailReset(String successfullyMessage){
        return this.SuccessfulResetMessage.getText().equals(successfullyMessage);
    }


}
