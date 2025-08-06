package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class TestBase {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeTest
    public void setupDriver(){
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
    }


    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
