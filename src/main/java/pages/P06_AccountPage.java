package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Random;


public class P06_AccountPage {
    WebDriver driver;
    public P06_AccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    // locators
    @FindBy(xpath = "//div/nav/div/ul/li/a")
    List<WebElement> categoryTabs;

    @FindBy(xpath = "//div/nav/div/ul/li/div/div/ul/li")
    List<WebElement> subCategory;

//    @FindBy(xpath = "//div/nav/div/ul/li/a")
//    List<WebElement> tabs;


    public void selectRandomCategory(){

        Random random = new Random();
        int index = random.nextInt(categoryTabs.size());
        System.out.println("Tab list size: " + driver.findElements(By.xpath("//div/nav/div/ul/li/a")).size());

        WebElement selectedTab = categoryTabs.get(index);
        System.out.println("Clicking tab: " + selectedTab.getText());
        selectedTab.click();

    }
    public void selectCategoryThenSubCategory(){

        Random random = new Random();

        // Step 1: Get all category tabs
        List<WebElement> categoryTabs = driver.findElements(By.xpath("//div/nav/div/ul/li/a"));
        System.out.println("Category tab count: " + categoryTabs.size());

        // Step 2: Pick and click a random category
        int categoryIndex = random.nextInt(categoryTabs.size());
        WebElement selectedCategory = categoryTabs.get(categoryIndex);
        System.out.println("Clicking category: " + selectedCategory.getText());
        selectedCategory.click();

        List<WebElement> subcategories = driver.findElements(By.xpath("//div/nav/div/ul/li/div/div/ul/li"));

        if (subcategories.isEmpty()) {
            System.out.println("No subcategories found under the selected category.");
            return;
        }

        // Step 4: Log all subcategories (optional)
        for (int i = 0; i < subcategories.size(); i++) {
            System.out.println("Subcategory [" + i + "]: " + subcategories.get(i).getText());
        }

        // Step 5: Select and click a random subcategory
        int subcategoryIndex = random.nextInt(subcategories.size());
        WebElement selectedSubcategory = subcategories.get(subcategoryIndex);
        System.out.println("Clicking subcategory: " + selectedSubcategory.getText());
        selectedSubcategory.click();


    }

//    public void selectRandomCategory(){
//
//        int tabLimit = Math.min(tabs.size(), 3);
//          System.out.println("Tab list size: " + tabs.size());
//          System.out.println("Tab limit: " + tabLimit);
//        Random random = new Random(tabLimit);
//        int index = random.nextInt();  // 0 to tabs.size()-1
//        WebElement selectedTab = tabs.get(index);
//        System.out.println("Clicking tab: " + selectedTab.getText());
//        selectedTab.click();
//
//    }

    public void clickRandomcat(String categoryTabs){

        this.categoryTabs.get(2).click();
    }

public void selectDifferentTags(){
    Random random = new Random();
    int randomIndex = random.nextInt(categoryTabs.size());
    System.out.println("Category tab count: " + categoryTabs.size());
    WebElement randomTab = categoryTabs.get(randomIndex);

    // Step 3: Hover over the selected tab
    Actions actions = new Actions(driver);
    actions.moveToElement(randomTab).perform();

    // Optional: Print out the hovered tab's text
    System.out.println("Hovered on category: " + randomTab.getText());

}

}
