package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P08_ProductPage {

    WebDriver driver;

    public P08_ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    // locators
    @FindBy(xpath = "(//div/button[@type=\"button\"])[5]")
    WebElement Item1AddToCart;

    @FindBy(xpath = "(//div/button[@type=\"button\"])[9]")
    WebElement Item2AddToCart;

    @FindBy(xpath = "(//div/button[@type=\"button\"])[6]")
    WebElement Item1AddToWishlist;

    @FindBy(xpath = "(//div/button[@type=\"button\"])[9]")
    WebElement Item2AddToWishlist;

    @FindBy(xpath = "(//div/button[@type=\"button\"])[7]")
    WebElement Item1AddToCompare;

    @FindBy(xpath = "(//div/button[@type=\"button\"])[10]")
    WebElement Item2AddToCompare;

    @FindBy(xpath = "((//div[@id=\"product-category\"]/div)[1]/a)[2]")
    WebElement SuccessfulMessage;



    public void clickItem1AddToCart(){Item1AddToCart.click();}
    public void clickItem2AddToCart(){Item2AddToCart.click();}
    public void clickItem1AddToWishlist(){Item1AddToWishlist.click();}
    public void clickItem2AddToWishlist(){Item2AddToWishlist.click();}
    public void clickItem1AddToCompare(){Item1AddToCompare.click();}
    public void clickItem2AddToCompare(){Item2AddToCompare.click();}


    public boolean isAdded(String successfullyMessage){
        System.out.println(this.SuccessfulMessage.getText());
        return this.SuccessfulMessage.getText().trim().equals(successfullyMessage);


    }

}
