package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class P07_CategoryPage {

    WebDriver driver;

    public P07_CategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    // locators
    @FindBy(xpath = "//div/nav/div/ul/li/a")
    List<WebElement> categoryTabs;

    @FindBy(xpath = "//div/nav/div/ul/li/div/div/ul/li")
    List<WebElement> subCategory;

    @FindBy(xpath = "(//h4)[1]")
    WebElement Item1;

    @FindBy(xpath = "//div/select")
    WebElement dropdown;



    public void clickComponentcat(String categoryTabs){

        this.categoryTabs.get(2).click();
    }

    public void clickMonitorsSubcat(String subCategory){

        this.subCategory.get(5).click();
    }

    public void clickItem1(){Item1.click();}

    public void selectColor(){

        Select select = new Select(dropdown);
        select.selectByVisibleText("Blue (+$3.60)");
    }


}
