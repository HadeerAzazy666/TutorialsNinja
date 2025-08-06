package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class P04_ProfilePage {
    WebDriver driver;

    public P04_ProfilePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }


    @FindBy(xpath = "//ul/li/a[text()='Logout']")
    WebElement logout;

    @FindBy(xpath = "(//div/input)[1]")
    WebElement searchField;

    @FindBy(xpath = "//div/div/span/button[@type=\"button\"]")
    WebElement searchButton;

    @FindBy(xpath = "//div/a[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//div/button/i[@class=\"fa fa-caret-down\"]")
    WebElement currencyArrow;

    @FindBy(xpath = "//ul/li/button")

    List<WebElement> currencyDropdown;

    @FindBy(xpath = "//div/ul/li/button[text()='£Pound Sterling']")
    WebElement poundOption;

    @FindBy(xpath = "//div/ul/li/button[text()='€Euro']")
    WebElement euroOption;

    @FindBy(xpath = "//div/ul/li/button[text()='$US Dollar']")
    WebElement USOption;




    // public action methods
    public void clickLogout(){
        logout.click();
    }

    public void insertValue(String searchField){

        this.searchField.sendKeys(searchField);
    }
    public void clickSearch(){
        searchButton.click();
    }
    public void clickContinue(){
        continueButton.click();
    }
    public void clickCurrencyArrow(){
        currencyArrow.click();
    }
    public void selectEuro(){
        euroOption.click();
    }
    public void selectPound(){
        poundOption.click();
    }
    public void selectUSDollar(){
        USOption.click();
    }

    public void selectRandomCurrency(){

        Random random = new Random();
        int index = random.nextInt(currencyDropdown.size());
        System.out.println("Tab list size: " + currencyDropdown.size());

        WebElement selectedCurr = currencyDropdown.get(index);
        System.out.println("Clicking tab: " + selectedCurr.getText());
        selectedCurr.click();

    }
}
